package tw.idv.ixercise.shopbackstage.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.ixercise.core.Core;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", schema = "THA101G1", catalog = "")
public class Product extends Core {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "productNo")
    private String productNo;
    @Basic
    @Column(name = "productName")
    private String productName;
    @Basic
    @Column(name = "picture")
    private String picture;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "amount")
    private Integer amount;
    @Basic
    @Column(name = "comment")
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        if (id != that.id) return false;
        if (productNo != null ? !productNo.equals(that.productNo) : that.productNo != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productNo != null ? productNo.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
