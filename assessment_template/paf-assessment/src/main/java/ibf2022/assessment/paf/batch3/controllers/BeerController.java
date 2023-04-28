package ibf2022.assessment.paf.batch3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.repositories.BeerRepository;
import ibf2022.assessment.paf.batch3.services.BeerService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("beer")
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
	
	@GetMapping(path="/style/{id}")
	public String populateStyleIdWBeerAndBreweries(Model m, HttpSession sess, @PathVariable int id){
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
		sess.setAttribute("beers", beers);

		return "view1";
	}
	//TODO Task 3 - view 1
	

	//TODO Task 4 - view 2

	
	//TODO Task 5 - view 2, place order

}
