package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {

    public static final String BEER_COUNT_STYLE= """
                                                    SELECT s.id, s.style_name, COUNT(*) AS \"beer count\"
                                                    FROM beers b
                                                    JOIN styles s ON b.style_id = s.id
                                                    GROUP BY s.id, s.style_name
                                                    ORDER BY COUNT(*) DESC, s.style_name ASC;
                                                """;
    
    public static final String BREWERIES_BY_BEER="""
                                                    SELECT b.id AS beer_id, b.name AS \"Beer Name\", 
                                                    b.descript AS description, br.id AS brewery_id, 
                                                    br.name AS \"Brewery Name\" FROM beers b 
                                                    JOIN breweries br ON b.brewery_id = br.id
                                                    JOIN styles s ON b.style_id = s.id
                                                    WHERE b.style_id = ?
                                                    ORDER BY b.name ASC;
                                                """;
}
