# ReviewComment
This is spring boot project for product catalog and review comments having following features
1. Rest endpoint to get all active categories for product
2. Rest end point to get active products for a category
3. Rest end point to get Product details for a product
4. Rest end point to add review comments
  a.validation for review comments for blank
  b.validation for review comments too short
  c.validation for no rating being provided by user
  d.validation for invaliding rating range
  e.validation for negative words --> any negative word will put comment for review
5. Review Engine to evaluating overall rating for a product --> This review engine will run at regular defined interval 
6. Integration of swagger2
7. Unit Test cases
8. Cache implementation
9. JPA-hibernate for Database access 
