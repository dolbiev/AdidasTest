﻿Code Annotation

For the convenience of the test with the resource, a separate class was created for each page, named according to the functionality. The classes that were created to work with modal windows were moved to a separate package. Inheritance was set up between classes. Classes not participating in the test were not filled, as there was no task for this. If necessary, I can fill it. The classes have web-elements configured in the first half, and methods of working with them in the second half.

In the MainTest, the Chrome web-driver, the page loading strategy and the full-screen page unfolding are first set. The test steps are performed in strict accordance with the task. Since the necessary text to get the ID and Amount values is unloaded in one piece, the code had to be slightly complicated in order to extract the necessary data. At the end, the values are compared and the result is output to the console.
A cycle has been added to the TitlePage class in the pressProduct method, since it is not clear whether the desired product will be on the first page of the list.
In the ProductPage class, a cycle has been added in the addToCart method just in case the Alert window suddenly does not appear.
Added to the CartPage class in the deleteProduct method: waiting for the "Delete" button to delete the product and refreshing the page to click on the "Place Order" button. The clickPlaceOrder method has added waiting and scrolling on the page to search for the "Place Order" button. This button brought a lot of inconvenience during writing the test, so I had to take such measures for stability.
Waiting for the first field was added to the PlaceOrderPage class, since the test started filling it in before it became active.
