//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P09 Movie Catalog
// Course:   CS 300 Spring 2021
//
// Author:   Zachary Collins
// Email:    ztcollins@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         -
// Online Sources:  -
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
    try {
      MovieTree tree1 = new MovieTree();
      if(tree1.size() != 0) {
        return false;
      }
      if(tree1.toString() != "") {
        return false;
      }
      boolean checkBool1 = tree1.addMovie(new Movie(2002, 8.0, "Finding Nemo"));
      if(checkBool1 != true) {
        return false;
      }
      if(tree1.isEmpty()) {
        return false;
      }
      if(tree1.size() != 1) {
        return false;
      }
      //System.out.println(tree1.toString());
      if(!tree1.toString().equals("[(Year: 2002) (Rate: 8.0) (Name: Finding Nemo)]\n")) {
        System.out.println("test");
        return false;
      }
      boolean checkBool2 = tree1.addMovie(new Movie(2012, 2.0, "Breaking Bad"));
      boolean checkBool3 = tree1.addMovie(new Movie(1999, 9.0, "Christmas"));
      boolean checkBool4 = tree1.addMovie(new Movie(2002, 8.1, "Finding Nemo Ripoff"));
      boolean checkBool5 = tree1.addMovie(new Movie(1998, 9.0, "Christmas OG"));
      boolean checkBool6 = tree1.addMovie(new Movie(1998, 9.0, "Christmas OG"));
      if(checkBool6 == true) {
        System.out.println("SHOULD BE FALSE");
        return false;
      }
      if(checkBool5 == false) {
        System.out.println("test fail");
        return false;
      }
      //System.out.println("SIZE: "+tree1.size());
      //System.out.println(tree1.toString());
    }
    catch (Exception e) {
      System.out.println("bruh!");
      return false;
    }
    
    System.out.println("TEST 1: passed");
    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for the
   * movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    MovieTree tree1 = new MovieTree();
    if(tree1.contains(2012, 0, "testy") != false) {
      return false;
    }
    tree1.addMovie(new Movie(2002, 8.0, "Finding Nemo"));
    tree1.addMovie(new Movie(2012, 2.0, "Breaking Bad"));
    tree1.addMovie(new Movie(1999, 9.0, "Christmas"));
    tree1.addMovie(new Movie(2002, 8.1, "Finding Nemo Ripoff"));
    tree1.addMovie(new Movie(1998, 9.0, "Christmas OG"));
    if(!tree1.contains(2012, 2.0, "Breaking Bad")) {
      return false;
    }
    System.out.println("TEST 2: passed");
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. 
   *       (*)
   *     /    \
   *  (*)      (*)
   *    \     /  \
   *    (*) (*)  (*)
   *             /
   *           (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    MovieTree tree1 = new MovieTree();
    MovieTree tree2 = new MovieTree();
    MovieTree tree3 = new MovieTree();
    //System.out.println(tree1.height());
    if(tree2.height() != 0) {
      return false;
    }
    tree3.addMovie(new Movie(2002, 8.0, "Finding Nemo"));
    tree1.addMovie(new Movie(2002, 8.0, "Finding Nemo"));
    //System.out.println(tree1.height());
    if(tree3.height() != 1) {
      return false;
    }
    tree1.addMovie(new Movie(2012, 2.0, "Breaking Bad"));
    tree1.addMovie(new Movie(2012, 2.1, "Breaking Baddiest"));
    tree1.addMovie(new Movie(1999, 9.0, "Christmas"));
 
    tree1.addMovie(new Movie(2002, 8.1, "Finding Nemo Ripoff"));
    tree1.addMovie(new Movie(1998, 9.2, "Christmas OG"));
    tree1.addMovie(new Movie(2012, 9.1, "Breaking Baddy"));
    //System.out.println(tree1.height());
    if(tree1.height() != 4) {
      return false;
    }
    System.out.println("TEST 3: passed");
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    MovieTree tree1 = new MovieTree();
    tree1.addMovie(new Movie(2012, 2.0, "Breaking Bad"));
    tree1.addMovie(new Movie(1999, 9.0, "Christmas"));
    tree1.addMovie(new Movie(2002, 8.1, "Finding Nemo Ripoff"));
    tree1.addMovie(new Movie(1998, 9.0, "Christmas OG"));
    Movie bestMovie = tree1.getBestMovie();
    //System.out.println(bestMovie.toString());
    if(!bestMovie.toString().equals("[(Year: 2012) (Rate: 2.0) (Name: Breaking Bad)]")) {
      return false;
    }
    tree1.addMovie(new Movie(3012, 2.1, "Dreaking Bad"));
    if(!tree1.getBestMovie().toString().equals("[(Year: 3012) (Rate: 2.1) (Name: Dreaking Bad)]")) {
      System.out.println(bestMovie.toString());
      return false;
    }
    System.out.println("TEST 4: passed");
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when called
   * on a non empty movie tree with one match, and two matches and more. Vary your search criteria
   * such that the lookup() method must check in left and right subtrees. (3) Ensures that the
   * MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie tree
   * with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    MovieTree tree1 = new MovieTree();
    try {
      tree1.lookup(2000, 1.1);
    }
    catch(NoSuchElementException e) {
      //System.out.println("caught exception");
    }
    
    tree1.addMovie(new Movie(2002, 8.0, "Finding Nemo"));
    tree1.addMovie(new Movie(2012, 2.0, "Breaking Bad"));
    tree1.addMovie(new Movie(1999, 9.0, "Christmas"));
    tree1.addMovie(new Movie(2002, 8.1, "Finding Nemo Ripoff"));
    tree1.addMovie(new Movie(1998, 9.0, "Christmas OG"));
    
    ArrayList<Movie> movieList = tree1.lookup(2002, 8.0);
    //System.out.println(movieList.get(0));
    
    tree1.addMovie(new Movie(2002, 8.0, "Bruh1"));
    tree1.addMovie(new Movie(2012, 2.0, "Bruh2"));
    tree1.addMovie(new Movie(1999, 9.0, "Bruh3"));
    tree1.addMovie(new Movie(2002, 8.1, "Bruh4"));
    tree1.addMovie(new Movie(1998, 9.0, "Bruh5"));
    
    ArrayList<Movie> movieList2 = tree1.lookup(2002, 8.0);
    /*for(int i = 0; i < movieList2.size(); i++) {
      System.out.println(movieList2.get(i));
    }*/
    
    System.out.println("TEST 5: passed");
    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    testAddMovieToStringSize();
    testContains();
    testHeight();
    testGetBestMovie();
    testLookup();
  }

}