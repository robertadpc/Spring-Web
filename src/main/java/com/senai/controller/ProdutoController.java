package com.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.senai.modelos.Produto;
import com.senai.repository.Produtos;

@Controller
@RequestMapping ("/produto")
public class ProdutoController {
	
	@Autowired(required=true)
	private Produtos produtos;
	
	@RequestMapping ("/novo") //produto/novo
	public ModelAndView produto() {
		ModelAndView mv = new ModelAndView("CadastroProduto.html"); 
		mv.addObject(new Produto());
		return mv; 
	}
	//Metodo salvar os dados no banco 
	@RequestMapping (method= RequestMethod.POST)
	public String salvar (Produto produto) {
		produtos.save(produto);
		return  "redirect:/produto/novo";
	}
	
	//Consultar Produto
	@RequestMapping ("/consulta") 
	public ModelAndView pesquisar() {
		List<Produto> todosProdutos = produtos.findAll();
		ModelAndView mv = new ModelAndView ("PesquisaProduto.html");
		mv.addObject("produtos",todosProdutos);
		return mv;
	}
	
	//Editar Produto
	@RequestMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Produto produto){
		ModelAndView mv = new ModelAndView ("CadastroProduto.html");
		mv.addObject(produto);
		return mv;
	}
	
	//Excluir Produto
	@RequestMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Produto produto ) {
		produtos.deleteById(produto.getId());
		return "redirect:/produto/consulta";
	
	}
}
