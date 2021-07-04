package com.spring.scheduler;

import java.io.File;

import com.spring.service.board.BoardService;
import com.spring.service.pds.PdsService;

public class SummernoteImageRemoveScheduler {
	
	private BoardService boardService;
	private PdsService pdsService;
	private String filePath;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void fileRemove()throws Exception {
		boolean existFile = false;
		
		File dir = new File(filePath);
		File[] files = dir.listFiles();
		if(files!=null) {
			for(File file : files) {
				existFile = false;
				
				existFile = existFile ||boardService.findFileInContent(file.getName())!=null;
				existFile = existFile ||pdsService.findFileInContent(file.getName())!=null;
				
				
				if(existFile) {
					System.out.println(file.getName()+" 파일은 존재합니다.");
					continue;
				}else {
					System.out.println(file.getName()+" 파일은 존재하지 않습니다. 삭제합니다.");
					file.delete();
				}
			}
		}
	}
	
	
}










