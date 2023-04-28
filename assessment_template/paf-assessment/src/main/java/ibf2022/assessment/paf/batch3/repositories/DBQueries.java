package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {

    public static final String BEER_COUNT_STYLE= """
                                                    SELECT s.id, s.style_name, COUNT(*) AS \"beer count\"
                                                    FROM beers b
                                                    JOIN styles s ON b.style_id = s.id
                                                    GROUP BY s.id, s.style_name
                                                    ORDER BY COUNT(*) DESC, s.style_name ASC;
                                                """;
    
}
