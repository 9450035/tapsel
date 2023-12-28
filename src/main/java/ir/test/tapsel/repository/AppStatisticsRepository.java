package ir.test.tapsel.repository;

import ir.test.tapsel.data.AppStatistics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppStatisticsRepository extends MongoRepository<AppStatistics, String> {
}
