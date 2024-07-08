package com.Model;


public class Carrier
{

    private int carrierId;
    private String carrierName;
    private int discountPercentageThirtyDaysAdvanceBooking;
    private int discountPercentageSixtyDaysAdvanceBooking;
    private int discountPercentageNinetyDaysAdvanceBooking;
    private int bulkBookingDiscount;
    private int refundPercentageForTicketCancellation2DaysBeforeTravelDate;
    private int refundPercentageForTicketCancellation10DaysBeforeTravelDate;
    private int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
    private int silverUserDiscount;
    private int  goldUserDiscount;
    private int platinumUserDiscount;



    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public int getDiscountPercentageThirtyDaysAdvanceBooking() {
        return discountPercentageThirtyDaysAdvanceBooking;
    }

    public void setDiscountPercentageThirtyDaysAdvanceBooking(int discountPercentageThirtyDaysAdvanceBooking) {
        this.discountPercentageThirtyDaysAdvanceBooking = discountPercentageThirtyDaysAdvanceBooking;
    }

    public int getDiscountPercentageSixtyDaysAdvanceBooking() {
        return discountPercentageSixtyDaysAdvanceBooking;
    }

    public void setDiscountPercentageSixtyDaysAdvanceBooking(int discountPercentageSixtyDaysAdvanceBooking) {
        this.discountPercentageSixtyDaysAdvanceBooking = discountPercentageSixtyDaysAdvanceBooking;
    }

    public int getDiscountPercentageNinetyDaysAdvanceBooking() {
        return discountPercentageNinetyDaysAdvanceBooking;
    }

    public void setDiscountPercentageNinetyDaysAdvanceBooking(int discountPercentageNinetyDaysAdvanceBooking) {
        this.discountPercentageNinetyDaysAdvanceBooking = discountPercentageNinetyDaysAdvanceBooking;
    }

    public int getBulkBookingDiscount() {
        return bulkBookingDiscount;
    }

    public void setBulkBookingDiscount(int bulkBookingDiscount) {
        this.bulkBookingDiscount = bulkBookingDiscount;
    }

    public int getRefundPercentageForTicketCancellation2DaysBeforeTravelDate() {
        return refundPercentageForTicketCancellation2DaysBeforeTravelDate;
    }

    public void setRefundPercentageForTicketCancellation2DaysBeforeTravelDate(int refundPercentageForTicketCancellation2DaysBeforeTravelDate) {
        this.refundPercentageForTicketCancellation2DaysBeforeTravelDate = refundPercentageForTicketCancellation2DaysBeforeTravelDate;
    }

    public int getRefundPercentageForTicketCancellation10DaysBeforeTravelDate() {
        return refundPercentageForTicketCancellation10DaysBeforeTravelDate;
    }

    public void setRefundPercentageForTicketCancellation10DaysBeforeTravelDate(int refundPercentageForTicketCancellation10DaysBeforeTravelDate) {
        this.refundPercentageForTicketCancellation10DaysBeforeTravelDate = refundPercentageForTicketCancellation10DaysBeforeTravelDate;
    }

    public int getRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate() {
        return refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
    }

    public void setRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate(int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate) {
        this.refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate = refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
    }

    public int getSilverUserDiscount() {
        return silverUserDiscount;
    }

    public void setSilverUserDiscount(int silverUserDiscount) {
        this.silverUserDiscount = silverUserDiscount;
    }

    public int getGoldUserDiscount() {
        return goldUserDiscount;
    }

    public void setGoldUserDiscount(int goldUserDiscount) {
        this.goldUserDiscount = goldUserDiscount;
    }

    public int getPlatinumUserDiscount() {
        return platinumUserDiscount;
    }

    public void setPlatinumUserDiscount(int platinumUserDiscount) {
        this.platinumUserDiscount = platinumUserDiscount;
    }

    public Carrier(String carrierName, int discountPercentageThirtyDaysAdvanceBooking, int discountPercentageSixtyDaysAdvanceBooking, int discountPercentageNinetyDaysAdvanceBooking, int bulkBookingDiscount, int refundPercentageForTicketCancellation2DaysBeforeTravelDate, int refundPercentageForTicketCancellation10DaysBeforeTravelDate, int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate, int silverUserDiscount, int goldUserDiscount, int platinumUserDiscount)
    {
        this.carrierName = carrierName;
        this.discountPercentageThirtyDaysAdvanceBooking = discountPercentageThirtyDaysAdvanceBooking;
        this.discountPercentageSixtyDaysAdvanceBooking = discountPercentageSixtyDaysAdvanceBooking;
        this.discountPercentageNinetyDaysAdvanceBooking = discountPercentageNinetyDaysAdvanceBooking;
        this.bulkBookingDiscount = bulkBookingDiscount;
        this.refundPercentageForTicketCancellation2DaysBeforeTravelDate = refundPercentageForTicketCancellation2DaysBeforeTravelDate;
        this.refundPercentageForTicketCancellation10DaysBeforeTravelDate = refundPercentageForTicketCancellation10DaysBeforeTravelDate;
        this.refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate = refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
        this.silverUserDiscount = silverUserDiscount;
        this.goldUserDiscount = goldUserDiscount;
        this.platinumUserDiscount = platinumUserDiscount;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "carrierId=" + carrierId +
                ", carrierName='" + carrierName + '\'' +
                ", discountPercentageThirtyDaysAdvanceBooking=" + discountPercentageThirtyDaysAdvanceBooking +
                ", discountPercentageSixtyDaysAdvanceBooking=" + discountPercentageSixtyDaysAdvanceBooking +
                ", discountPercentageNinetyDaysAdvanceBooking=" + discountPercentageNinetyDaysAdvanceBooking +
                ", bulkBookingDiscount=" + bulkBookingDiscount +
                ", refundPercentageForTicketCancellation2DaysBeforeTravelDate=" + refundPercentageForTicketCancellation2DaysBeforeTravelDate +
                ", refundPercentageForTicketCancellation10DaysBeforeTravelDate=" + refundPercentageForTicketCancellation10DaysBeforeTravelDate +
                ", refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate=" + refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate +
                ", silverUserDiscount=" + silverUserDiscount +
                ", goldUserDiscount=" + goldUserDiscount +
                ", platinumUserDiscount=" + platinumUserDiscount +
                '}';
    }
}
