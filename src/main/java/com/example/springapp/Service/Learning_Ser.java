package com.example.springapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springapp.Model.Learning;
import com.example.springapp.Repository.Learning_Repo;

@Service
public class Learning_Ser {
	@Autowired
	Learning_Repo stRepo;
	
	public Learning saveDetails(Learning e)
	{
		return stRepo.save(e);
	}
	public List<Learning> getDetails()
	{
		return stRepo.findAll();
	}
	public Learning updateDetails(Learning e1)
	{
		return stRepo.saveAndFlush(e1);
	}
	public void deleteDetails(int Id)
	{
		stRepo.deleteById(Id);
	}public List<Learning> getSorted(String field) {
		return stRepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<Learning> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Learning> page =stRepo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

}