package com.app.Controller;



import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.ProductsService;
import com.app.dto.LaptopDto;
import com.app.dto.TvsDto;
import com.app.dto.WatchesDto;
import com.app.entity.Laptop;
import com.app.entity.Tv;
import com.app.entity.Watch;
import com.app.repository.LaptopRepository;
import com.app.repository.TvRepository;
import com.app.repository.WatchRepository;


@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	@Autowired
	private TvRepository tvsRepository;
	
	@Autowired
	private WatchRepository watchRepository;
	
	@Autowired
	private ProductsService productService;
	
	
	@GetMapping(value="/getAllWatches")
	public List<Watch> getAllWatches()
	{
	List<Watch> watches = watchRepository.findAll();
	return watches;
	}
	@PostMapping(value="/saveWatches")
	public JSONObject saveWatches(@RequestBody Watch watch) {
	Watch save = watchRepository.save(watch);
	if(save!=null)
	{
	JSONObject response = productService.productsResponse("ok","Watches Details are Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productService.productsResponse("Not ok","Watches Details are NOT Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}


	}
	@PutMapping(value="/updateWatches/{productId}")
	public JSONObject updateWatch(@RequestBody WatchesDto watchDto,@PathVariable int productId)
	{
	Watch watch=new Watch();
	String model = watchDto.getModel();
	String inches = watchDto.getInches();
	double price = watchDto.getPrice();
	watch.setId(productId);
	watch.setModel(model);
	watch.setInches(inches);
	watch.setPrice(price);
	Watch save = watchRepository.save(watch);
	if(save!=null)
	{
	JSONObject response = productService.productsResponse("ok","Watch Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productService.productsResponse("Not ok","Watch Details are NOT Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}

	}
	@DeleteMapping(value="/deleteWatches/{id}")
	public JSONObject deleteWatch(@PathVariable int id)
	{
	Optional<Watch> findById = watchRepository.findById(id);
	Watch watches = findById.get();
	if(watches!=null)
	{
	watchRepository.deleteById(id);
	JSONObject response = productService.productsResponse("ok","Watch Details are Getting Deleted succesfully" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productService.productsResponse("Not ok","Watch Details are NOT Getting Deleted Plese enter valid Watch Id" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	}
	@GetMapping(value="/getAllLaptops")
	public List<Laptop> getAllLaptops()
	{
	List<Laptop> laptops =laptopRepository.findAll();
	return laptops;
	}
	@PostMapping(value="/saveLaptops")
	public JSONObject saveLaptops(@RequestBody Laptop laptop) {
	Laptop save = laptopRepository.save(laptop);
	if(save!=null)
	{
	JSONObject response = productService.productsResponse("ok","Laptops Details are Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productService.productsResponse("Not ok","Laptops Details are NOT Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}

	}
	@PutMapping(value="/updateLaptops/{productId}")
	public JSONObject updateLaptops(@RequestBody LaptopDto laptopDto,@PathVariable int productId)
	{
	Laptop laptop=new Laptop();
	String model = laptopDto.getModel();
	String inches = laptopDto.getInches();
	double price = laptopDto.getPrice();
	laptop.setId(productId);
	laptop.setModel(model);
	laptop.setInches(inches);
	laptop.setPrice(price);
	Laptop save = laptopRepository.save(laptop);
	if(save!=null)
	{
	JSONObject response = productService.productsResponse("ok","Laptops Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productService.productsResponse("Not ok","Laptops Details are NOT Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	}
	@DeleteMapping(value="/deleteLaptops/{id}")
	public JSONObject deleteLaptops(@PathVariable int id)
	{
	Optional<Laptop> findById = laptopRepository.findById(id);
	Laptop laptops = findById.get();
	if(laptops!=null)
	{
	laptopRepository.deleteById(id);
	JSONObject response = productService.productsResponse("ok","Laptops Details are Getting Deleted Succesfully" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{



	JSONObject response = productService.productsResponse("Not ok","Laptops Details are NOT Getting Deleted Please enter valid laptop id" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	}
	@GetMapping(value="/getTvs")
	public List<Tv> getAllTvs()
	{
	List<Tv> tvs = tvsRepository.findAll();
	return tvs;
	}
	@PostMapping(value="/saveTvs")
	public JSONObject saveTvs(@RequestBody Tv tv) {
	Tv save = tvsRepository.save(tv);
	if(save!=null)
	{
	JSONObject response = productService.productsResponse("ok","Tv Details are Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productService.productsResponse("Not ok","Tv Details are NOT Getting saved" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}

	}
	@PutMapping(value="/updateTvs/{productId}")
	public JSONObject updateTvs(@RequestBody TvsDto tvDto,@PathVariable int productId)
	{
	Tv tv=new Tv();
	String model = tvDto.getModel();
	String inches = tvDto.getInches();
	double price = tvDto.getPrice();
	tv.setId(productId);
	tv.setModel(model);
	tv.setInches(inches);
	tv.setPrice(price);
	Tv save = tvsRepository.save(tv);
	if(save!=null)
	{
	JSONObject response = productService.productsResponse("ok","Tv Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productService.productsResponse("Not ok","Tv Details are NOT Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}

	}
	@DeleteMapping(value="/deleteTvs/{id}")
	public JSONObject deleteTvs(@PathVariable int id)
	{
	Optional<Tv> findById = tvsRepository.findById(id);
	Tv tvs= findById.get();
	if(tvs!=null)
	{
	tvsRepository.deleteById(id);
	JSONObject response = productService.productsResponse("ok","Tv recdord getting deleted" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = productService.productsResponse("Not ok","Tv Details are NOT Getting Deleted Please enter valid tv id" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	}


	
	
	

}
