/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author luxal
 */
@Entity
@Table(name = "car_model")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CarModel.findAll", query = "SELECT c FROM CarModel c"),
        @NamedQuery(name = "CarModel.findById", query = "SELECT c FROM CarModel c WHERE c.id = :id"),
        @NamedQuery(name = "CarModel.findByTitle", query = "SELECT c FROM CarModel c WHERE c.title = :title")})
public class CarModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "id_car_brand", referencedColumnName = "id")
    @ManyToOne
    private CarBrand idCarBrand;
    @OneToMany(mappedBy = "idCarModel")
    private List<Vehicle> vehicleList;

    public CarModel() {
    }

    public CarModel(String title, CarBrand idCarBrand) {
        this.title = title;
        this.idCarBrand = idCarBrand;
    }

    public CarModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CarBrand getIdCarBrand() {
        return idCarBrand;
    }

    public void setIdCarBrand(CarBrand idCarBrand) {
        this.idCarBrand = idCarBrand;
    }

    @XmlTransient
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarModel)) {
            return false;
        }
        CarModel other = (CarModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject5.CarModel[ id=" + id + " ]";
    }

}
