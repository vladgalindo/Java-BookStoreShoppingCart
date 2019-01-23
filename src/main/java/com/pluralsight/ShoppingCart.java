package com.pluralsight;

import java.util.ArrayList;
import javax.inject.Inject;
import javax.persistence.Index;

public class ShoppingCart {
 @Inject
 private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
 private double dblOrderTotal ;

 public int getLineItemCount() {
  return cartItems.size();
 }

 public void addCartItem(Book book, int quantity) {
   CartItem cartItem = new CartItem(book, quantity);
   cartItems.add(cartItem);
   calculateOrderTotal();
 }

 public void addCartItem(CartItem cartItem) {
  cartItems.add(cartItem);
 }

 public CartItem getCartItem(int iItemIndex) {
  CartItem cartItem = null;
  if(cartItems.size()>iItemIndex) {
   cartItem = cartItems.get(iItemIndex);
  }
  return cartItem;
 }

 public ArrayList<CartItem> getCartItems() {
  return cartItems;
 }
 public void setCartItems(ArrayList<CartItem> cartItems) {
  this.cartItems = cartItems;
 }
 public double getOrderTotal() {
  return dblOrderTotal;
 }
 public void setOrderTotal(double dblOrderTotal) {
  this.dblOrderTotal = dblOrderTotal;
 }

 protected void calculateOrderTotal() {
  double dblTotal = 0;
  for(int counter=0;counter<cartItems.size();counter++) {
   CartItem cartItem = cartItems.get(counter);
   dblTotal+=cartItem.getTotalCost();

  }
  setOrderTotal(dblTotal);
 }

 public void deleteCartItem(int index) {
  try{
   this.cartItems.remove(index);
  }
  catch (IndexOutOfBoundsException e){
   e.printStackTrace();
  }
 }

 public void updateCartItem(int index, int quantity) {
  try {
   CartItem item = this.cartItems.get(index);
   item.setQuantity(quantity);
  }
  catch (IndexOutOfBoundsException e) {
   e.printStackTrace();
  }
 }

}
