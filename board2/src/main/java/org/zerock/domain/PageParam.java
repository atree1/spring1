package org.zerock.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageParam {

	private int page;
	private double per;
	private int start, end, total;
	private boolean prev, next;
	private int bno;
	private int display;
	private String keyword;
	private String[] types;
	private Map<String, String> cond; // 2번째 방법
	private boolean extend;

	public PageParam() {
		this.page = 1;
		this.display = 10;
		this.per = (double) display;
	}

	public void setCond() {
		cond = new HashMap<>();
		if(types!=null) {
		for (int i = 0; i < types.length; i++) {
			cond.put(types[i], keyword);
		}
		}

	}

	public void setTotal(int total) {
		this.total = total;
		this.end = (int) (Math.ceil(this.page / this.per)) * this.display;
		this.start = end - display+1;

		if (this.end * display >= total) {
			this.end = (int) (Math.ceil(this.total / per));
			this.next = false;
		} else {
			this.next = true;
		}

		this.prev = start != 1;
	}

	public int getSkip() {
		return (this.page - 1) * display;
	}

	public void setDisplay(int display) {
		this.display = display;
		this.per = (double) (display);
	}

	public int getDisplay() {
		return this.display;
	}

	public String getLink(String path) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path).queryParam("bno", this.bno).queryParam("types",this.types).queryParam("keyword", this.keyword)
				.queryParam("page", this.page);
		return builder.toUriString();

	}

}
