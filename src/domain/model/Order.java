package domain.model;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Order{
    public int orderId;
    private String date;
    private String address;
    private String place;
    private String zip;
    private boolean invoice;
    private ArrayList<Product> productlist;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy - h:mm a");

    public Order(){
        setId();
        this.date = sdf.format(new Date());
        productlist = new ArrayList<>();
    }
    public Order(String address, String place, String zip, boolean invoice) {

        this.date = sdf.format(new Date());
        setId();
        setAddress(address);
        setPlace(place);
        setZip(zip);
        setInvoice(invoice);
        productlist = new ArrayList<>();
    }
    public Object clone() throws CloneNotSupportedException{
        Order order = (Order) super.clone();
        return order;
    }

    public void setId() {
        this.orderId = ThreadLocalRandom.current().nextInt(100,200+1);
    }
    public Integer getOrderId(){
        return orderId;
    }
    public String getDate(){
        return date;
    }
    public int getTotalOrderPrice(){
        int res = 0;
        for(Product x : this.productlist){
            res += x.getPrice();
        }
        return res;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.trim().isEmpty()) {
            throw new DomainException("No address given");
        }
        this.address = address;
    }
    public void addProduct(Product p){
        if(p == null){
            throw new DomainException();
        }
        productlist.add(p);
    }
    public ArrayList<Product> getProductlist(){
        return productlist;
    }

    public void setProductlist(ArrayList<Product> list){
        this.productlist = list;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        if (place.trim().isEmpty()) {
            throw new DomainException("No place given");
        }
        this.place = place;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        if (zip.trim().isEmpty()) {
            throw new DomainException("No address given");
        }
        try {
            double x = Double.parseDouble(zip);
            if(x<=0){
                throw new DomainException("Please enter a valid ZIP code (negative)");
            }
            this.zip = zip;
        } catch(NumberFormatException nfe) {
            throw new NumberFormatException("Please enter a valid ZIP code");
        }
    }

    public boolean getInvoice() {
        return invoice;
    }

    public void setInvoice(boolean invoice) {
        this.invoice = invoice;
    }

    public List<Product> getProducts(){
        return productlist;
    }
}
