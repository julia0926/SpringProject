package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Document;
import net.skhu.model.Pagination;
import net.skhu.repository.FolderRepository;
import net.skhu.repository.DocumentRepository;

@Controller
@RequestMapping("document")
public class DocumentController {

    @Autowired DocumentRepository documentRepository;
    @Autowired FolderRepository folderRepository;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        List<Document> documents = documentRepository.findByFolderId(pagination);
        model.addAttribute("documents", documents);
        model.addAttribute("folders", folderRepository.findAll());
        return "document/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("document", new Document());
        model.addAttribute("folders", folderRepository.findAll());
        return "document/edit";
    }

    @PostMapping("create")
    public String create(Model model, Document document, Pagination pagination) {
        documentRepository.save(document);
        pagination.setFi(0);
        int lastPage = (int)Math.ceil((double)documentRepository.count() / pagination.getSz());
        pagination.setPg(1);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        Document document = documentRepository.findById(id).get();
        model.addAttribute("document", document);
        model.addAttribute("folders", folderRepository.findAll());
        return "document/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Document document, Pagination pagination) {
        documentRepository.save(document);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
        documentRepository.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}

