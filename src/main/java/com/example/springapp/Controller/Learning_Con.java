package com.example.springapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.Model.Learning;
import com.example.springapp.Service.Learning_Ser;

@RestController
@CrossOrigin
public class Learning_Con {

	@Autowired
	Learning_Ser stuService;
	@PostMapping("/post")
	public Learning addinfo(@RequestBody Learning st) {
		return stuService.saveDetails(st);
	}
	@GetMapping("/showDetails")
	public List<Learning> fetchDetails()
	{
		return stuService.getDetails();
	}
	@PutMapping("/updateDetails")
	public Learning updateInfo(@RequestBody Learning st1)
	{
		return stuService.updateDetails(st1);
	}
	@DeleteMapping("/deleteDetails/{id}")
	public String deleteInfo(@PathVariable("id") int id) {
		stuService.deleteDetails(id);
		
		return "Details is Deleted";
		//return stuService.getDetails();
	}
	//sorting
	@GetMapping("/product/{field}")
	public List<Learning> getWithSort(@PathVariable String field) {
		return stuService.getSorted(field);
	}

	// pagination
	@GetMapping("/product/{offset}/{pageSize}")
	public List<Learning> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		return stuService.getWithPagination(offset, pageSize);
	}
}