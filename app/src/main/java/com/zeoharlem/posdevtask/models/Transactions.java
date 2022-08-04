package com.zeoharlem.posdevtask.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Transactions implements Parcelable {
    @SerializedName("creditAccountNo")
    @Expose
    public String creditAccountNo;

    @SerializedName("debitAccountNo")
    @Expose
    public String debitAccountNo;

    @SerializedName("transactionBy")
    @Expose
    public String transactionBy;

    @SerializedName("channelName")
    @Expose
    public String channelName;

    @SerializedName("statusName")
    @Expose
    public String statusName;

    @SerializedName("userType")
    @Expose
    public int userType;

    @SerializedName("userId")
    @Expose
    public int userId;

    @SerializedName("initiator")
    @Expose
    public String initiator;

    @SerializedName("archived")
    @Expose
    public boolean archived;

    @SerializedName("product")
    @Expose
    public String product;

    @SerializedName("hasProduct")
    @Expose
    public boolean hasProduct;

    @SerializedName("senderName")
    @Expose
    public String senderName;

    @SerializedName("receiverName")
    @Expose
    public String receiverName;

    @SerializedName("balanceBeforeTransaction")
    @Expose
    public double balanceBeforeTransaction;

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("reference")
    @Expose
    public String reference;

    @SerializedName("transactionType")
    @Expose
    public int transactionType;

    @SerializedName("transactionTypeName")
    @Expose
    public String transactionTypeName;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("narration")
    @Expose
    public String narration;

    @SerializedName("amount")
    @Expose
    public String amount;

    @SerializedName("creditAccountNumber")
    @Expose
    public String creditAccountNumber;

    @SerializedName("debitAccountNumber")
    @Expose
    public String deditAccountNumber;

    @SerializedName("parentReference")
    @Expose
    public String parentReference;

    @SerializedName("transactionDate")
    @Expose
    public String transactionDate;

    @SerializedName("credit")
    @Expose
    public double credit;

    @SerializedName("debit")
    @Expose
    public double debit;

    @SerializedName("balanceAfterTransaction")
    @Expose
    public double balanceAfterTransaction;

    @SerializedName("sender")
    @Expose
    public String sender;

    @SerializedName("receiver")
    @Expose
    public String receiver;

    @SerializedName("channel")
    @Expose
    public int channel;

    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("charges")
    @Expose
    public double charges;

    @SerializedName("aggregatorCommission")
    @Expose
    public double aggregatorCommission;

    @SerializedName("hasCharges")
    @Expose
    public boolean hasCharges;

    @SerializedName("agentCommission")
    @Expose
    public int agentCommission;

    @SerializedName("debitAccountNumber")
    @Expose
    public String debitAccountNumber;

    @SerializedName("initiatedBy")
    @Expose
    public String initiatedBy;

    @SerializedName("stateId")
    @Expose
    public int stateId;

    @SerializedName("lgaId")
    @Expose
    public int lgaId;

    @SerializedName("regionId")
    @Expose
    public int regionId;

    @SerializedName("aggregatorId")
    @Expose
    public int aggregatorId;

    @SerializedName("isCredit")
    @Expose
    public boolean isCredit;

    public Transactions(Parcel in) {
        creditAccountNo = in.readString();
        debitAccountNo = in.readString();
        transactionBy = in.readString();
        channelName = in.readString();
        statusName = in.readString();
        userType = in.readInt();
        userId = in.readInt();
        initiator = in.readString();
        archived = in.readByte() != 0;
        product = in.readString();
        hasProduct = in.readByte() != 0;
        senderName = in.readString();
        receiverName = in.readString();
        balanceBeforeTransaction = in.readDouble();
        id = in.readInt();
        reference = in.readString();
        transactionType = in.readInt();
        transactionTypeName = in.readString();
        description = in.readString();
        narration = in.readString();
        amount = in.readString();
        creditAccountNumber = in.readString();
        deditAccountNumber = in.readString();
        parentReference = in.readString();
        credit = in.readDouble();
        debit = in.readDouble();
        balanceAfterTransaction = in.readDouble();
        sender = in.readString();
        receiver = in.readString();
        channel = in.readInt();
        status = in.readInt();
        charges = in.readDouble();
        aggregatorCommission = in.readDouble();
        hasCharges = in.readByte() != 0;
        agentCommission = in.readInt();
        debitAccountNumber = in.readString();
        initiatedBy = in.readString();
        stateId = in.readInt();
        lgaId = in.readInt();
        regionId = in.readInt();
        aggregatorId = in.readInt();
        isCredit = in.readByte() != 0;
    }

    public static final Creator<Transactions> CREATOR = new Creator<Transactions>() {
        @Override
        public Transactions createFromParcel(Parcel in) {
            return new Transactions(in);
        }

        @Override
        public Transactions[] newArray(int size) {
            return new Transactions[size];
        }
    };

    public Transactions() {

    }

    public String getCreditAccountNo() {
        return creditAccountNo;
    }

    public void setCreditAccountNo(String creditAccountNo) {
        this.creditAccountNo = creditAccountNo;
    }

    public String getDebitAccountNo() {
        return debitAccountNo;
    }

    public void setDebitAccountNo(String debitAccountNo) {
        this.debitAccountNo = debitAccountNo;
    }

    public String getTransactionBy() {
        return transactionBy;
    }

    public void setTransactionBy(String transactionBy) {
        this.transactionBy = transactionBy;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public boolean isHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public double getBalanceBeforeTransaction() {
        return balanceBeforeTransaction;
    }

    public void setBalanceBeforeTransaction(double balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreditAccountNumber() {
        return creditAccountNumber;
    }

    public void setCreditAccountNumber(String creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
    }

    public String getDeditAccountNumber() {
        return deditAccountNumber;
    }

    public void setDeditAccountNumber(String deditAccountNumber) {
        this.deditAccountNumber = deditAccountNumber;
    }

    public String getParentReference() {
        return parentReference;
    }

    public void setParentReference(String parentReference) {
        this.parentReference = parentReference;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public void setBalanceAfterTransaction(double balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public double getAggregatorCommission() {
        return aggregatorCommission;
    }

    public void setAggregatorCommission(double aggregatorCommission) {
        this.aggregatorCommission = aggregatorCommission;
    }

    public boolean isHasCharges() {
        return hasCharges;
    }

    public void setHasCharges(boolean hasCharges) {
        this.hasCharges = hasCharges;
    }

    public int getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(int agentCommission) {
        this.agentCommission = agentCommission;
    }

    public String getDebitAccountNumber() {
        return debitAccountNumber;
    }

    public void setDebitAccountNumber(String debitAccountNumber) {
        this.debitAccountNumber = debitAccountNumber;
    }

    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getLgaId() {
        return lgaId;
    }

    public void setLgaId(int lgaId) {
        this.lgaId = lgaId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getAggregatorId() {
        return aggregatorId;
    }

    public void setAggregatorId(int aggregatorId) {
        this.aggregatorId = aggregatorId;
    }

    public boolean isCredit() {
        return isCredit;
    }

    public void setCredit(boolean credit) {
        isCredit = credit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(creditAccountNo);
        parcel.writeString(debitAccountNo);
        parcel.writeString(transactionBy);
        parcel.writeString(channelName);
        parcel.writeString(statusName);
        parcel.writeInt(userType);
        parcel.writeInt(userId);
        parcel.writeString(initiator);
        parcel.writeByte((byte) (archived ? 1 : 0));
        parcel.writeString(product);
        parcel.writeByte((byte) (hasProduct ? 1 : 0));
        parcel.writeString(senderName);
        parcel.writeString(receiverName);
        parcel.writeDouble(balanceBeforeTransaction);
        parcel.writeInt(id);
        parcel.writeString(reference);
        parcel.writeInt(transactionType);
        parcel.writeString(transactionTypeName);
        parcel.writeString(description);
        parcel.writeString(narration);
        parcel.writeString(amount);
        parcel.writeString(creditAccountNumber);
        parcel.writeString(deditAccountNumber);
        parcel.writeString(parentReference);
        parcel.writeDouble(credit);
        parcel.writeDouble(debit);
        parcel.writeDouble(balanceAfterTransaction);
        parcel.writeString(sender);
        parcel.writeString(receiver);
        parcel.writeInt(channel);
        parcel.writeInt(status);
        parcel.writeDouble(charges);
        parcel.writeDouble(aggregatorCommission);
        parcel.writeByte((byte) (hasCharges ? 1 : 0));
        parcel.writeInt(agentCommission);
        parcel.writeString(debitAccountNumber);
        parcel.writeString(initiatedBy);
        parcel.writeInt(stateId);
        parcel.writeInt(lgaId);
        parcel.writeInt(regionId);
        parcel.writeInt(aggregatorId);
        parcel.writeByte((byte) (isCredit ? 1 : 0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return userType == that.userType && userId == that.userId && archived == that.archived && hasProduct == that.hasProduct && Double.compare(that.balanceBeforeTransaction, balanceBeforeTransaction) == 0 && id == that.id && transactionType == that.transactionType && Double.compare(that.credit, credit) == 0 && Double.compare(that.debit, debit) == 0 && Double.compare(that.balanceAfterTransaction, balanceAfterTransaction) == 0 && channel == that.channel && status == that.status && Double.compare(that.charges, charges) == 0 && Double.compare(that.aggregatorCommission, aggregatorCommission) == 0 && hasCharges == that.hasCharges && agentCommission == that.agentCommission && stateId == that.stateId && lgaId == that.lgaId && regionId == that.regionId && aggregatorId == that.aggregatorId && isCredit == that.isCredit && creditAccountNo.equals(that.creditAccountNo) && debitAccountNo.equals(that.debitAccountNo) && transactionBy.equals(that.transactionBy) && channelName.equals(that.channelName) && statusName.equals(that.statusName) && initiator.equals(that.initiator) && product.equals(that.product) && senderName.equals(that.senderName) && receiverName.equals(that.receiverName) && reference.equals(that.reference) && transactionTypeName.equals(that.transactionTypeName) && description.equals(that.description) && narration.equals(that.narration) && creditAccountNumber.equals(that.creditAccountNumber) && deditAccountNumber.equals(that.deditAccountNumber) && parentReference.equals(that.parentReference) && transactionDate.equals(that.transactionDate) && sender.equals(that.sender) && receiver.equals(that.receiver) && debitAccountNumber.equals(that.debitAccountNumber) && initiatedBy.equals(that.initiatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditAccountNo, debitAccountNo, transactionBy, channelName, statusName, userType, userId, initiator, archived, product, hasProduct, senderName, receiverName, balanceBeforeTransaction, id, reference, transactionType, transactionTypeName, description, narration, amount, creditAccountNumber, deditAccountNumber, parentReference, transactionDate, credit, debit, balanceAfterTransaction, sender, receiver, channel, status, charges, aggregatorCommission, hasCharges, agentCommission, debitAccountNumber, initiatedBy, stateId, lgaId, regionId, aggregatorId, isCredit);
    }

    public static DiffUtil.ItemCallback<Transactions> transactionsItemCallback = new DiffUtil.ItemCallback<Transactions>() {
        @Override
        public boolean areItemsTheSame(@NonNull Transactions oldItem, @NonNull Transactions newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Transactions oldItem, @NonNull Transactions newItem) {
            return oldItem.equals(newItem);
        }
    };
}

