package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Order;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import ibf2022.assessment.paf.batch3.services.BeerService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/beer")
public class BeerController {

	@Autowired
	BeerService beerSvc;

	@Autowired
	BeerRepository beerRepo;

	//TODO Task 2 - view 0
	@GetMapping
	public String populateAllBeerStyle(Model m, HttpSession sess){
		List<Style> styles = beerRepo.getStyles();
		m.addAttribute("styles", styles);
		// no issues here, still working
		sess.setAttribute("styles", styles);
		return "view0";
	}
	
	//TODO Task 3 - view 1
	@GetMapping(path="/style/{id}")
	public String populateStyleIdWBeerAndBreweries(Model m, @PathVariable int id){
		List<Style> styles = beerRepo.getStyles();
		List<Beer> beers = beerRepo.getBreweriesByBeer(id);
		m.addAttribute("beers", beers);
		m.addAttribute("styles", styles);
		String styleName = null;
		for (Style style : styles) {
			if (style.getStyleId() == id) {
				styleName = style.getName();
				break;
			}
		}
		m.addAttribute("styleName", styleName);

		return "view1";
	}
	

	//TODO Task 4 - view 2
	@GetMapping(path="/style/brewery/{breweryId}")
	public String populateBeerBreweryOrderForm(Model m, @PathVariable int breweryId){
		try{
		Optional<Brewery> br = beerRepo.getBeersFromBrewery(breweryId);
		List<Beer> beers = br.get().getBeers();
		m.addAttribute("br", br.get());
		m.addAttribute("beers", beers);

		String breweryName = null;
		for (Beer beer : beers) {
			if (beer.getBreweryId() == breweryId) {
				breweryName = beer.getBreweryName();
				break;
			}
		}
		m.addAttribute("breweryName", br.get().getName());

		return "view2";
		}catch(NoSuchElementException ex){
			return "errorbrewery";
		}

	}
	// TODO Task 5 - view 2, place order
	@PostMapping(path="/style/brewery/{breweryId}/order", consumes= MediaType.APPLICATION_JSON_VALUE)
	public String newBeerOrder(@ModelAttribute Order o, @PathVariable int breweryId, 
								@RequestParam Map<String,String> beerOrderParams){
		String beerId = beerOrderParams.get("beerId");
		String qty = beerOrderParams.get("quantity");
		return "view4";
	}

}
