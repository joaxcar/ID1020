/*
 * BinaryTree.java
 * Johan Carlsson
 * Created: 2019-08-30
 * Edited: 2019-09-01
 * 
 * Class implementing a binary tree that takes the first int as a root and places the folowint integers
 * that are lower to the left and higher to the right.
 * Use add to add a value.
 * Use search to se if a value is present in the tree
 * Use walkInfix/Prefix/Postfix to walk the tree
*/

import java.util.Scanner;

public class BinaryTree{
  /* Node structure */
  private class Node{
    Node left;
    Node right;
    int key;

    Node(int key){
      this.key = key;
    }
  }

  Node root;

  // Create new instance of SingleLinkedList
  public BinaryTree(int rootKey){
    root = new Node(rootKey);
  }

  // Push a key into the stack before the first lower key
  public void add(int key){
    if (root == null){
      root = new Node(key);
    }
    else{
      insert(root, new Node(key));
    }
  }
  
  // Place Node after a target Node
  private void insert(Node root, Node newNode){
    if(root.key > newNode.key){
      if(root.left == null){
        root.left = newNode;
      } else{
        insert(root.left, newNode);
      }
    } else{
      if(root.right == null){
        root.right = newNode;
      } else{
        insert(root.right, newNode);
      }
    }
  }

  // Search for a value in the tree
  public boolean search(int key){
    return search(root, key);
  }

  // Recursive search through the tree
  private boolean search(Node root, int key){
    if(root.key == key){
      return true;
    }
    if(root.left != null && search(root.left, key)){
      return true;
    }
    if(root.right != null && search(root.right, key)){
      return(true);
    }
    return false;
  }

  // Return the list as a String
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    walkPrefix(sb, root);
    sb.append('\n');
    walkInfix(sb, root);
    sb.append('\n');
    walkPostfix(sb, root);
    return sb.toString();
  }

  // Walk tree prefix
  public String walkPrefix(){
    StringBuilder sb = new StringBuilder();
    walkPrefix(sb, root);
    return sb.toString();
  }

  // Walk tree infix
  public String walkInfix(){
    StringBuilder sb = new StringBuilder();
    walkInfix(sb, root);
    return sb.toString();
  }

  // Walk tree postfix
  public String walkPostfix(){
    StringBuilder sb = new StringBuilder();
    walkPostfix(sb, root);
    return sb.toString();
  }
  
  // recursive walks infix prefix postfix
  private void walkPrefix(StringBuilder sb, Node root){
    sb.append(root.key);
    sb.append(" ");
    if(root.left != null){
      walkPrefix(sb, root.left);
    }
    if(root.right != null){
      walkPrefix(sb, root.right);
    }
  }

  private void walkInfix(StringBuilder sb, Node root){
    if(root.left != null){
      walkInfix(sb, root.left);
    }
    sb.append(root.key);
    sb.append(" ");
    if(root.right != null){
      walkInfix(sb, root.right);
    }
  }

  private void walkPostfix(StringBuilder sb, Node root){
    if(root.left != null){
      walkPostfix(sb, root.left);
    }
    if(root.right != null){
      walkPostfix(sb, root.right);
    }
    sb.append(root.key);
    sb.append(" ");
  }
  

  /*
     Main method that takes ints on Stdin and pushes them to the ring
     When all ints are read, it prints the sack and pops all items
     Send in argument "test" to perform unit tests.
  */
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    BinaryTree list = new BinaryTree(in.nextInt());
    while(in.hasNextInt()){
      list.add(in.nextInt());
    }
    // Print list in diferent orders
    System.out.println(list.walkPrefix());
    System.out.println(list.walkInfix());
    System.out.println(list.walkPostfix());

    // Search for a series of keys
    for(int i = 0; i < 15; i++){
      System.out.println(i + ": " + list.search(i));
    }

    // Unit tests
    if(args.length != 0 && args[0].equals("test")){
      BinaryTree testList = new BinaryTree(7);
      // Test one element list
      assert(testList.walkPrefix().equals("7 "));
      assert(testList.walkInfix().equals("7 "));
      assert(testList.walkPostfix().equals("7 "));
      assert(testList.search(7));
      assert(!testList.search(2));
      // Test with more elements
      testList.add(2);
      assert(testList.walkPrefix().equals("7 2 "));
      assert(testList.walkInfix().equals("2 7 "));
      assert(testList.walkPostfix().equals("2 7 "));
      assert(testList.search(2));
      assert(!testList.search(6));
      testList.add(8);
      assert(testList.walkPrefix().equals("7 2 8 "));
      assert(testList.walkInfix().equals("2 7 8 "));
      assert(testList.walkPostfix().equals("2 8 7 "));
      assert(testList.search(8));
      assert(!testList.search(6));
      // Test with negative element
      testList.add(-1);
      assert(testList.walkPrefix().equals("7 2 -1 8 "));
      assert(testList.walkInfix().equals("-1 2 7 8 "));
      assert(testList.walkPostfix().equals("-1 2 8 7 "));
      assert(testList.search(-1));
      assert(!testList.search(-6));
    }
  }
}
