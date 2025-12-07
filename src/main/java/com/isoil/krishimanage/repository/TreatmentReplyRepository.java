package com.isoil.krishimanage.repository;

import com.isoil.krishimanage.model.TreatmentReply;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TreatmentReplyRepository extends JpaRepository<TreatmentReply, Long> {
    List<TreatmentReply> findByDiseaseReportIdOrderByReplyDateAsc(Long diseaseReportId);
    List<TreatmentReply> findByDiseaseReportIdAndRepliedByOrderByReplyDateAsc(Long diseaseReportId, String repliedBy);
}
