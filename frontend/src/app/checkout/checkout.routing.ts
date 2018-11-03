import { CheckoutComponent } from "./checkout.component";
import { ResultComponent } from "./result/result.component";
import { BillingDetailsComponent } from "./billing-details/billing-details.component";
import { ProductsComponent } from "./products/products.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

export const checkoutRoutes: Routes = [
  {
    path: "checkout",
    component: CheckoutComponent,
    children: [
      {
        path: "",
        component: ProductsComponent,
        outlet: "checkOutlet"
      },
      {
        path: "billing-details",
        component: BillingDetailsComponent,
        outlet: "checkOutlet"
      },
      {
        path: "result",
        component: ResultComponent,
        outlet: "checkOutlet"
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(checkoutRoutes)],
  exports: [RouterModule]
})
export class CheckoutRoutingModule {}