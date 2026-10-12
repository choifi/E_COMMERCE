package kr.hhplus.be.server.infrastructure.coupon;

import kr.hhplus.be.server.domain.coupon.Coupon;
import kr.hhplus.be.server.domain.coupon.CouponStatus;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "coupon")
public class CouponEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private int couponId;
    
    @Column(name = "user_id", nullable = false)
    private int userId;
    
    @Column(name = "policy_id", nullable = false)
    private int policyId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CouponStatus status;
    
    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;
    
    public CouponEntity() {}
    
    public int getCouponId() { return couponId; }
    public void setCouponId(int couponId) { this.couponId = couponId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getPolicyId() { return policyId; }
    public void setPolicyId(int policyId) { this.policyId = policyId; }
    public CouponStatus getStatus() { return status; }
    public void setStatus(CouponStatus status) { this.status = status; }
    public LocalDateTime getCreatedTime() { return createdTime; }
    public void setCreatedTime(LocalDateTime createdTime) { this.createdTime = createdTime; }
    
    public Coupon toDomain() {
        Coupon coupon = new Coupon(userId, policyId);
        coupon.setCouponId(couponId);
        coupon.setStatus(status);
        coupon.setCreatedTime(createdTime);
        return coupon;
    }
    
    public static CouponEntity fromDomain(Coupon coupon) {
        CouponEntity entity = new CouponEntity();
        entity.setCouponId(coupon.getCouponId());
        entity.setUserId(coupon.getUserId());
        entity.setPolicyId(coupon.getPolicyId());
        entity.setStatus(coupon.getStatus());
        entity.setCreatedTime(coupon.getCreatedTime());
        return entity;
    }
} 