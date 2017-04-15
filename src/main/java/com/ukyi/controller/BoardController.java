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
@RequestMapping("/board/*")//����URL����
public class BoardController {
  
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
  
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)//�Է�(���)��
    public String registerGET()throws Exception{
	   logger.info("register GET��û...");	
		
       return "board/register";//���������� ������ ����!!	
    }
	
	@RequestMapping(value="/register", method=RequestMethod.POST)//�Է�ó��
	public String registerPOST(BoardVO board, RedirectAttributes rttr)//Model model)
			   throws Exception{
		logger.info("register POST��û...");	
		logger.info("BoardVO::"+ board);
		service.regist(board);
		
		//model.addAttribute("msg","SUCCESS");
		rttr.addFlashAttribute("msg", "SUCCESS");
		//request.setAttribute() �Ǵ� session.setAttribute()�� ��ü ����!!
		
		//return "board/success";//���������� ������ ����!!	
		return "redirect:/board/listAll";//��ϱ� ���Է� ����
	}
	
	@RequestMapping("/listAll")//�Խù� ��ü ��� ��û
	public String listAll(Model model)throws Exception{
		logger.info("��ülist ��û..."+ model);	
		model.addAttribute("list", service.listAll());
	   return "board/listAll";
	}
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)//�Խù� ��ü ��� ��û
	public void listCri(Criteria cri, Model model)throws Exception{
		logger.info("��ülistCri ��û...");	
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping("/read")//Ư���Խù� �б�
	public String read(int bno,Model model)throws Exception{
	   logger.info("�Խù� �б�...["+ bno +"]");
	   model.addAttribute("boardVO", service.read(bno));
	   return "board/read";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGET(BoardVO board, Model model)throws Exception{//������ ���̱�
	  logger.info("�Խù� ������...["+ board.getBno() +"]");
	  model.addAttribute("boardVO",board);
	  return "board/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board,
			                 RedirectAttributes attr)throws Exception{//����ó��(DB)
      logger.info("�Խù� ����ó��...["+ board.getBno() +"]");
      logger.info("�Խù� ����ó��[Ÿ��Ʋ]...["+ board.getTitle() +"]");
	  
     
      service.modify(board);
	  
      attr.addFlashAttribute("msg","SUCCESS");	  
	  return "redirect:/board/listAll";
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam("bno") int boardNo, 
			              RedirectAttributes attr)throws Exception{
		logger.info("�Խù� ����...["+ boardNo +"]");
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




