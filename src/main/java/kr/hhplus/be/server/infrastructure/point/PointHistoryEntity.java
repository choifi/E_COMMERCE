package kr.hhplus.be.server.infrastructure.point;

import kr.hhplus.be.server.domain.point.PointHistory;
import kr.hhplus.be.server.domain.point.PointHistoryType;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "point_history")
public class PointHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private int historyId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "point_id", nullable = false)
    private int pointId;

    @Column(name = "point_amount", nullable = false)
    private int pointAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PointHistoryType type;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    @Column(name = "updated_time", nullable = false)
    private LocalDateTime updatedTime;

    public PointHistoryEntity() {}

    // Getter, Setter
    public int getHistoryId() { return historyId; }
    public void setHistoryId(int historyId) { this.historyId = historyId; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public int getPointId() { return pointId; }
    public void setPointId(int pointId) { this.pointId = pointId; }
    
    public int getPointAmount() { return pointAmount; }
    public void setPointAmount(int pointAmount) { this.pointAmount = pointAmount; }
    
    public PointHistoryType getType() { return type; }
    public void setType(PointHistoryType type) { this.type = type; }
    
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
    
    public LocalDateTime getUpdatedTime() { return updatedTime; }
    public void setUpdatedTime(LocalDateTime updatedTime) { this.updatedTime = updatedTime; }

    // 도메인 변환 메서드
    public PointHistory toDomain() {
        PointHistory history = 
            new PointHistory(userId, pointId, pointAmount, type);
        
        history.setHistoryId(historyId);
        history.setCreatedTime(createdTime);
        history.setUpdatedTime(updatedTime);
        
        return history;
    }

    // 도메인 객체에서 변환
    public static PointHistoryEntity fromDomain(PointHistory history) {
        PointHistoryEntity entity = new PointHistoryEntity();
        entity.setHistoryId(history.getHistoryId());
        entity.setUserId(history.getUserId());
        entity.setPointId(history.getPointId());
        entity.setPointAmount(history.getPointAmount());
        entity.setType(history.getType());
        entity.setCreatedTime(history.getCreatedTime());
        entity.setUpdatedTime(history.getUpdatedTime());
        
        return entity;
    }
} 