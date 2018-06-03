import {Component, OnInit} from '@angular/core';
import {PersonnelService} from '../personnel.service';

@Component({
  selector: 'app-blood-bank',
  templateUrl: './blood-bank.component.html',
  styleUrls: ['./blood-bank.component.css']
})
export class BloodBankComponent implements OnInit {
  cards = [
    {
      cols: 1,
      rows: 1,
      imageUrl: 'assets/blood-images/0+.png',
      plasma: 0,
      redcell: 0,
      thrombocyte: 0,
      whole: 0
    },
    {
      cols: 1,
      rows: 1,
      imageUrl: 'assets/blood-images/a+.png',
      plasma: 0,
      redcell: 0,
      thrombocyte: 0,
      whole: 0
    },
    {
      cols: 1,
      rows: 1,
      imageUrl: 'assets/blood-images/b+.png',
      plasma: 0,
      redcell: 0,
      thrombocyte: 0,
      whole: 0
    },
    {
      cols: 1,
      rows: 1,
      imageUrl: 'assets/blood-images/ab+.png',
      plasma: 0,
      redcell: 0,
      thrombocyte: 0,
      whole: 0
    },
    {
      cols: 1,
      rows: 1,
      imageUrl: 'assets/blood-images/0-.png',
      plasma: 0,
      redcell: 0,
      thrombocyte: 0,
      whole: 0
    },
    {
      cols: 1,
      rows: 1,
      imageUrl: 'assets/blood-images/a-.png',
      plasma: 0,
      redcell: 0,
      thrombocyte: 0,
      whole: 0
    },
    {
      cols: 1,
      rows: 1,
      imageUrl: 'assets/blood-images/b-.png',
      plasma: 0,
      redcell: 0,
      thrombocyte: 0,
      whole: 0
    },
    {
      cols: 1,
      rows: 1,
      imageUrl: 'assets/blood-images/ab-.png',
      plasma: 0,
      redcell: 0,
      thrombocyte: 0,
      whole: 0
    }
  ];

  constructor(private service: PersonnelService) {
  }

  ngOnInit() {
    this.service.getBloodCounter().subscribe(counter => this.fillStatistic(counter));
  }

  private fillStatistic(counter) {
    console.log(counter);
    let types, rhs, categories;
    for (types = 0; types < 4; types++) {
      const type = Object.keys(counter)[types];
      console.log(type);
      for (rhs = 0; rhs < 2; rhs++) {
        const rh = Object.keys(counter[type])[rhs];
        console.log(rh);
        for (categories = 0; categories < 4; categories++) {
          const category = Object.keys(counter[type][rh])[categories];
          this.cards[types + rhs * 4][category.substr(4).toLowerCase()] = counter[type][rh][category];
        }
      }
    }
  }
}
