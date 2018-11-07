package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Board;
import org.zerock.domain.PageParam;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(@ModelAttribute("pageObj")PageParam pageParam,Model model) {
		log.info("list get");
		pageParam.setCond();
		pageParam.setTotal(service.getTotal(pageParam));
		model.addAttribute("list",service.getList(pageParam));
		log.info(pageParam);
	}
	
	@GetMapping("/register")
	public void registerget() {
		log.info("register get.................");
	}
	@PostMapping("/register")
	public String register(Board board,RedirectAttributes rttr) {
		int result=service.register(board);
		rttr.addFlashAttribute("result",result==1?"SUCCESS":"FAIL");
		return "redirect:/board/list";
	}
	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("pageObj") PageParam pageParam ,Model model) {
		log.info("read or modify get.................");
		log.info(pageParam);
		pageParam.setCond();
		model.addAttribute("board",service.read(pageParam));
	}
	@PostMapping("/modify")
	public String modify(@ModelAttribute("pageObj")PageParam pageParam,Board board,RedirectAttributes rttr) {
		int result=service.modify(board);
		pageParam.setCond();
		rttr.addFlashAttribute("result",result==1?"SUCCESS":"FAIL");
		return pageParam.getLink("redirect:/board/read");
	}
	@PostMapping("/remove")
	public String remove(@ModelAttribute("pageObj")PageParam pageParam,RedirectAttributes rttr) {
		pageParam.setCond();
		int result=service.remove(pageParam);
		rttr.addFlashAttribute("result",result==1?"SUCCESS":"FAIL");
		
		return pageParam.getLink("redirect:/board/list");
	}
	
}
