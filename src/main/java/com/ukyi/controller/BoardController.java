package com.ukyi.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ukyi.domain.BoardVO;
import com.ukyi.domain.Criteria;
import com.ukyi.domain.PageMaker;
import com.ukyi.service.BoardService;

import oracle.net.aso.l;

@Controller
@RequestMapping("/board/*")//공통URL정의
public class BoardController {
  
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
  
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)//입력(등록)폼
    public String registerGET()throws Exception{
	   logger.info("register GET요청...");	
		
       return "board/register";//스프링에게 뷰정보 전달!!	
    }
	
	@RequestMapping(value="/register", method=RequestMethod.POST)//입력처리
	public String registerPOST(BoardVO board, RedirectAttributes rttr)//Model model)
			   throws Exception{
		logger.info("register POST요청...");	
		logger.info("BoardVO::"+ board);
		service.regist(board);
		
		//model.addAttribute("msg","SUCCESS");
		rttr.addFlashAttribute("msg", "SUCCESS");
		//request.setAttribute() 또는 session.setAttribute()로 대체 가능!!
		
		//return "board/success";//스프링에게 뷰정보 전달!!	
		return "redirect:/board/listAll";//등록글 재입력 방지
	}
	
	@RequestMapping("/listAll")//게시물 전체 목록 요청
	public String listAll(Model model)throws Exception{
		logger.info("전체list 요청..."+ model);	
		model.addAttribute("list", service.listAll());
	   return "board/listAll";
	}
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)//게시물 전체 목록 요청
	public void listCri(Criteria cri, Model model)throws Exception{
		logger.info("전체listCri 요청...");	
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping("/read")//특정게시물 읽기
	public String read(int bno,Model model)throws Exception{
	   logger.info("게시물 읽기...["+ bno +"]");
	   model.addAttribute("boardVO", service.read(bno));
	   return "board/read";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGET(BoardVO board, Model model)throws Exception{//수정폼 보이기
	  logger.info("게시물 수정폼...["+ board.getBno() +"]");
	  model.addAttribute("boardVO",board);
	  return "board/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board,
			                 RedirectAttributes attr)throws Exception{//수정처리(DB)
      logger.info("게시물 수정처리...["+ board.getBno() +"]");
      logger.info("게시물 수정처리[타이틀]...["+ board.getTitle() +"]");
	  
     
      service.modify(board);
	  
      attr.addFlashAttribute("msg","SUCCESS");	  
	  return "redirect:/board/listAll";
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam("bno") int boardNo, 
			              RedirectAttributes attr)throws Exception{
		logger.info("게시물 삭제...["+ boardNo +"]");
		service.remove(boardNo);
		attr.addFlashAttribute("msg","SUCCESS");
	   return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception{
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(131);
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
}




