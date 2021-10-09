package com.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Audit implements Serializable {

    public List<Data> data;
    public Meta meta;
    public Pagination pagination;

    public static class Reference {
        public int dtAuditID;
        public String snapShotDate;
        public String company;
        public String idFund;
        public String fundName;
    }

    public static class Client {
        public int id;
        public String tag;
        public String name;
        public String memberFirm;
        public Date created;
    }

    public static class FundProperties {
        public String currencyCode;
        public String fundName;
        public String depositary;
    }

    public static class ModifiedBy {
        public String id;
        public int accessFailedCount;
        public String email;
        public String userName;
        public String firstName;
        public String lastName;
        public String locale;
        public List<Object> associatedMemberFirms;
        public Date created;
        public String createdById;
    }

    public static class CreatedBy {
        public String id;
        public int accessFailedCount;
        public String email;
        public String userName;
        public String firstName;
        public String lastName;
        public String locale;
        public List<Object> associatedMemberFirms;
        public Date created;
        public String createdById;
        public boolean emailConfirmed;
        public boolean lockoutEnabled;
        public boolean phoneNumberConfirmed;
        public boolean twoFactorEnabled;
    }

    public static class EngagementRole {
        public String id;
        public String name;
        public String description;
    }

    public static class ReviewedBy {
        public String id;
        public int accessFailedCount;
        public String email;
        public boolean emailConfirmed;
        public boolean lockoutEnabled;
        public boolean phoneNumberConfirmed;
        public boolean twoFactorEnabled;
        public String userName;
        public String firstName;
        public String lastName;
        public String locale;
        public List<Object> associatedMemberFirms;
        public Date created;
    }

    public static class Phase {
        public String name;
        public String status;
        public ReviewedBy reviewedBy;
        public Date reviewedOn;
        public CreatedBy createdBy;
        public Date created;
    }

    public static class AuditStatus {
        public List<Phase> phases;
    }

    public static class Data implements Serializable {
        public Reference reference;
        public Client client;
        public FundProperties fundProperties;
        public String matEngagementId;
        public String matEntityId;
        public String matEntityName;
        public int matFiscalYear;
        public String grouping;
        public String accountingStandard;
        public double materialityFactor;
        public double performanceMaterialityFactor;
        public double clearlyTrivialFactor;
        public boolean flagPublicInterestEntity;
        public String empireTimeCode;
        public String auditPeriodStartDate;
        public String auditPeriodEndDate;
        public String navCurrentPeriodStartDate;
        public String navCurrentPeriodEndDate;
        public String navPreviousPeriodEndDate;
        public String valuationDate;
        public String opinionDate;
        public String status;
        public String internalStatus;
        public String bookvalueBookingMethod;
        public Date modifiedOn;
        public ModifiedBy modifiedBy;
        public Date createdOn;
        public boolean flagArchived;
        public boolean flagReadOnly;
        public CreatedBy createdBy;
        public String rowVersion;
        public EngagementRole engagementRole;
        public AuditStatus auditStatus;
        public boolean flagHideSummary;
        public boolean flagShowTotals;
        public boolean flagShowImport;
        public boolean flagRiskAssessment;
        public double averageNAV;
        public double averageNAVdays;
        public double yearEndNAV;
        public double materialityThreshold;
        public double performanceMaterialityThreshold;
        public double clearlyTrivialThreshold;
        public String archiveControlDate;
    }

    public static class Meta {
        public int code;
    }

    public static class Pagination {
        public int total;
        public int returned;
        public String next_url;
        public String first_url;
        public String last_url;
    }
}
