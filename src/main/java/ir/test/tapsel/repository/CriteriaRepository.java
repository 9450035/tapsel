package ir.test.tapsel.repository;

import ir.test.tapsel.data.AppStatistics;
import ir.test.tapsel.domain.AppStatisticsModel;
import ir.test.tapsel.mapper.AppStatisticsMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CriteriaRepository {
    private final MongoTemplate mongoTemplate;
    private final AppStatisticsMapper appStatisticsMapper;

    public CriteriaRepository(MongoTemplate mongoTemplate, AppStatisticsMapper appStatisticsMapper) {
        this.mongoTemplate = mongoTemplate;
        this.appStatisticsMapper = appStatisticsMapper;
    }

    public List<AppStatisticsModel> getStatistics(Date startDate, Date endDate, Integer type) {
        var query = new Query();

        if (startDate != null || endDate != null) {
            Criteria c = Criteria.where("reportTime");
            if (startDate != null) {
                c.gt(startDate);
            }
            if (endDate != null) {
                c.lte(endDate);
            }
            query.addCriteria(c);
        }
        if (type != null) {
            query.addCriteria(Criteria.where("type").is(type));
        }
        query.with(Sort.by(Sort.Direction.ASC, "reportTime"));
        return mongoTemplate.find(query, AppStatistics.class).stream().map(appStatisticsMapper::toDTO).toList();
    }

}
