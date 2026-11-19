package businessClass;


import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<LineItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(ArrayList<LineItem> items) {
        this.items = items != null ? items : new ArrayList<>();
    }

    // Alias for cart attribute
    public ArrayList<LineItem> getCart() {
        return items;
    }

    public void setCart(ArrayList<LineItem> cart) {
        this.items = cart;
    }

    public int getCount() {
        return items.size();
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(LineItem item) {
        if (item == null || item.getProduct() == null) {
            return;
        }
        String id = item.getProduct().getId();
        int quantity = item.getQuantity();
        for (LineItem lineItem : items) {
            if (lineItem.getProduct() != null && lineItem.getProduct().getId().equalsIgnoreCase(id)) {
                lineItem.setQuantity(lineItem.getQuantity() + quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        if (item == null || item.getProduct() == null) {
            return;
        }
        String id = item.getProduct().getId();
        removeItemById(id);
    }

    public void removeItemById(String id) {
        if (id == null) {
            return;
        }
        items.removeIf(item -> item.getProduct() != null && id.equalsIgnoreCase(item.getProduct().getId()));
    }

    public void updateQuantity(String id, int quantity) {
        if (id == null) {
            return;
        }
        if (quantity <= 0) {
            removeItemById(id);
        } else {
            for (LineItem lineItem : items) {
                if (lineItem.getProduct() != null && id.equalsIgnoreCase(lineItem.getProduct().getId())) {
                    lineItem.setQuantity(quantity);
                    return;
                }
            }
        }
    }

    public LineItem getLineItem(int i) {
        return items.get(i);
    }

    public double getTotalAmount() {
        double total = 0.0;
        for (LineItem item : items) {
            total += item.getTotal();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public double getTotal() {
        return getTotalAmount();
    }

    public void clear() {
        items.clear();
    }


}
