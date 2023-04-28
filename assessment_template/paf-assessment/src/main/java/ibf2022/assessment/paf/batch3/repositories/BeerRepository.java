package ibf2022.assessment.paf.batch3.repositories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;

@Repository
public class BeerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// TODO: Task 2
	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		List<Style> listOfBeerStyle = new LinkedList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(BEER_COUNT_STYLE);
		while(rs.next()){
			listOfBeerStyle.add(Style.createFromSQLRowSet(rs));
		}
		return listOfBeerStyle;
	}
		
	// TODO: Task 3
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(int styleId) {
		List<Beer> listOfBeerAndBreweries = new LinkedList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(BREWERIES_BY_BEER, styleId);
		System.out.println("testing");
		while(rs.next()){
			listOfBeerAndBreweries.add(Beer.createFromSQLRowSet(rs));
		}
		return listOfBeerAndBreweries;
	}
	
	// TODO: Task 4
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(int breweryId/* You can add any number of parameters here */) {
		List<Brewery> getBreweriesInformation = new LinkedList<>();
		List<Beer> beers = new ArrayList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(BREWERIES, breweryId);
		while(rs.next()){
			getBreweriesInformation.add(Brewery.createFromSQLRowSet(rs));
			Beer b = Beer.createFromSQLRowSet(rs);
			beers.add(b);
		}
		if (!getBreweriesInformation.isEmpty()){
			// only one brewery so should work
			Brewery br = getBreweriesInformation.get(0);
			br.setBeers(beers);
			System.out.println("+++" + Optional.of(br));
			return Optional.of(br);
		}
		// cannot change or remove this return
		return Optional.empty();
	}
}
