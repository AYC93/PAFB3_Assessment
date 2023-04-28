package ibf2022.assessment.paf.batch3.repositories;

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

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		List<Style> listOfBeerStyle = new LinkedList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(BEER_COUNT_STYLE);
		while(rs.next()){
			listOfBeerStyle.add(Style.createFromSQLRowSet(rs));
		}
		// TODO: Task 2
		return listOfBeerStyle;
	}
		
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(int styleId) {
		List<Beer> listOfBeerAndBreweries = new LinkedList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(BREWERIES_BY_BEER, styleId);
		System.out.println("testing");
		while(rs.next()){
			listOfBeerAndBreweries.add(Beer.createFromSQLRowSet(rs));
		}
		// TODO: Task 3
		for (Beer b: listOfBeerAndBreweries){
			System.out.println(b.toString());
		}
		return listOfBeerAndBreweries;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(/* You can add any number of parameters here */) {
		// TODO: Task 4

		return Optional.empty();
	}
}
