package repositories;

import model.DiseaseReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseReportRepository extends JpaRepository<DiseaseReport, Long> {
}
