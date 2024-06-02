package actions.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import locators.swaglabs.ProductDetailsPageLocators;
import utils.HelperClass;

public class ProductDetailsPageActions {
    ProductDetailsPageLocators productDetailsPageLocators = null;

    public ProductDetailsPageActions() {
        this.productDetailsPageLocators = new ProductDetailsPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), productDetailsPageLocators);
    }

    public WebElement getProductDescriptionOnCatalog() {
        return productDetailsPageLocators.productDescriptionOnCatalog;
    }

    public void productDetailsButtonClick() {
        productDetailsPageLocators.productDetailsImageBtn.click();
    }

    public WebElement getProductNameOnDetails() {
        return productDetailsPageLocators.productNameOnDetails;
    }

    public WebElement getProductDescriptionOnDetails() {
        return productDetailsPageLocators.productDescriptionOnDetails;
    }

    public WebElement getProductPriceOnDetails() {
        return productDetailsPageLocators.productPriceOnDetails;
    }

    public WebElement getProductDetailsPage() {
        return productDetailsPageLocators.productDetailsPage;
    }

    public void addToCartButtonClick() {
        productDetailsPageLocators.addToCartBtn.click();
    }

    public void backButtonClick() {
        productDetailsPageLocators.backButton.click();
    }

    public boolean isProductDetailsPageDisplayed() {
        return productDetailsPageLocators.productDetailsPage.isDisplayed();
    }


    public boolean isProductInCart(String productNameOnDetails, String productDescriptionOnDetails, String productPriceOnDetails) {
        // Cek apakah produk yang ditambahkan terlihat di keranjang
        boolean addedProductInCart = productDetailsPageLocators.addedProductOnCart.isDisplayed();

        // Ambil detail produk yang ditambahkan ke keranjang
        String addedProductName = productDetailsPageLocators.addedProductNameOnCart.getText();
        String addedProductDescription = productDetailsPageLocators.addedProductDescriptionOnCart.getText();
        String addedProductPrice = productDetailsPageLocators.addedProductPriceOnCart.getText();

        // Cek apakah kuantitas produk terlihat di keranjang
        boolean addedProductQuantityInCart = productDetailsPageLocators.addedProductQuantityOnCart.isDisplayed();

        // Cek apakah semua atribut produk sesuai
        boolean productDetailsMatch = productNameOnDetails.equals(addedProductName) &&
                productDescriptionOnDetails.equals(addedProductDescription) &&
                productPriceOnDetails.equals(addedProductPrice);

        // Return true jika produk terlihat di keranjang, kuantitas terlihat, dan semua atribut produk sesuai
        return addedProductInCart && addedProductQuantityInCart && productDetailsMatch;
    }
    
    public int getItemCount() {
        String itemCountText = productDetailsPageLocators.cartItemCount.getText();
        return itemCountText.isEmpty() ? 0 : Integer.parseInt(itemCountText);
    }
    
}
