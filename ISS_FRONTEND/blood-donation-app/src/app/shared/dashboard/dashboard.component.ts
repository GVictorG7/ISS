import {Component} from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  cards = [
    {
      title: 'Donatii',
      cols: 1,
      rows: 1,
      imageUrl: 'https://png.kisspng.com/20180331/jhq/kisspng-heart-rate-blood-donation-pulse-donation-blood-5abf4b58afa173.0345391415224861047194.png',
      counter: 2
    },
    {
      title: 'Cereri de sange',
      cols: 1,
      rows: 1,
      imageUrl: 'https://cdn0.iconfinder.com/data/icons/hand-color/100/Hand__5-512.png',
      counter: 7
    }
  ];
}

