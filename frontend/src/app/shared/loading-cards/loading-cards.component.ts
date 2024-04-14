import { Component, Input } from "@angular/core";
import { NgForOf, NgIf } from "@angular/common";
import { MatIconModule } from "@angular/material/icon";

@Component({
  selector: "app-loading-cards",
  styleUrls: ["./loading-cards.component.scss"],
  templateUrl: "./loading-cards.component.html",
  imports: [NgForOf, MatIconModule, NgIf],
  standalone: true,
})
export class LoadingCardsComponent {
  @Input()
  loading = false;

  @Input()
  error = false;

  protected width = "25%";
  protected lines = Array.from(Array(2).keys());
  protected cards = Array.from(Array(3).keys());

  constructor() {}

  @Input()
  set numCards(numCards: number) {
    this.cards = Array.from(Array(numCards).keys());
  }

  @Input()
  set numLines(numLines: number) {
    this.lines = Array.from(Array(numLines).keys());
  }
}
