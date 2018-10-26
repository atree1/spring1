package org.zerock.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.StoreVO;
import org.zerock.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/store/*")
@Log4j
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class StoreController {

	private StoreService service;

	@GetMapping("/{idx}")
	public StoreVO get(@PathVariable("idx") int idx) {
		return service.get(idx);
	}

	@PostMapping("/new")
	public String add(@RequestBody StoreVO vo) {
		log.info(vo);
		return "success";

	}

	@GetMapping("/sample")
	public StoreVO get() {

		StoreVO vo = new StoreVO();
		vo.setSno(1);
		vo.setSname("종로분식");
		vo.setMenu("제육덮밥");
		vo.setLat(37.123);
		vo.setLng(123.4567);
		return vo;
	}

	@DeleteMapping("/{idx}")
	public String remove(@PathVariable("idx") int idx) {
		log.info("remove......................."+idx);
		service.remove(idx);
		return "success";
	}
}
