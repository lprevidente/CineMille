import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AllFilmsComponent } from "./pages/all-films/all-films.component";
import { HistoryComponent } from "./pages/history/history.component";

const routes: Routes = [
  { path: "", redirectTo: "all", pathMatch: "full" },
  { path: "all", component: AllFilmsComponent },
  { path: "history", component: HistoryComponent },
  { path: "**", redirectTo: "all" },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FilmsRoutingModule {}
