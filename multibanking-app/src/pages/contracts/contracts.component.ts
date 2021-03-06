import { Component, ViewChild } from "@angular/core";
import { NavParams, AlertController, ToastController, LoadingController, Navbar, NavController } from "ionic-angular";

import { ImageService } from '../../services/image.service';
import { BankAccountService } from "../../services/bankAccount.service";
import { ContractService } from "../../services/contract.service";
import { BankAccess, ContractEntity } from "../../model/multibanking/models";
import { SortedContracts } from "../../model/sortedContracts";

@Component({
  selector: 'contracts',
  templateUrl: 'contracts.component.html'
})
export class ContractsComponent {

  bankAccess: BankAccess;
  bankAccountId: string;
  getLogo: Function;
  contracts: { income: SortedContracts, expenses: SortedContracts };

  @ViewChild(Navbar) navBar: Navbar;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    private alertCtrl: AlertController,
    private toastCtrl: ToastController,
    private loadingCtrl: LoadingController,
    private contractService: ContractService,
    private bankAccountService: BankAccountService,
    public logoService: ImageService
  ) {
    this.bankAccess = navParams.data.bankAccess;
    this.bankAccountId = navParams.data.bankAccount.id;
    this.getLogo = logoService.getImage;
  }

  ngOnInit() {
    this.bankAccountService.bookingsChangedObservable.subscribe(changed => {
      this.loadContracts();
    });
    this.loadContracts();
  }

  ionViewDidLoad() {
    this.navBar.backButtonClick = (e: UIEvent) => {
      this.navCtrl.parent.viewCtrl.dismiss();
    };
  }

  loadContracts() {
    this.contractService.getContracts(this.bankAccess.id, this.bankAccountId)
      .subscribe(contracts => {
        this.contractsLoaded(contracts);
      })
  }

  contractsLoaded(contracts: ContractEntity[]) {
    this.contracts = {
      income: {
        WEEKLY: [],
        MONTHLY: [],
        TWOMONTHLY: [],
        QUARTERLY: [],
        HALFYEARLY: [],
        YEARLY: []
      },
      expenses: {
        WEEKLY: [],
        MONTHLY: [],
        TWOMONTHLY: [],
        QUARTERLY: [],
        HALFYEARLY: [],
        YEARLY: []
      }
    };
    contracts.forEach(contract => {
      if (contract.amount > 0) {
        switch (contract.interval) {
          case ContractEntity.IntervalEnum.WEEKLY:
            this.contracts.income.WEEKLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.MONTHLY:
            this.contracts.income.MONTHLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.TWOMONTHLY:
            this.contracts.income.TWOMONTHLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.QUARTERLY:
            this.contracts.income.QUARTERLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.HALFYEARLY:
            this.contracts.income.HALFYEARLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.YEARLY:
            this.contracts.income.YEARLY.push(contract);
            break;
        }
      } else {
        switch (contract.interval) {
          case ContractEntity.IntervalEnum.WEEKLY:
            this.contracts.expenses.WEEKLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.MONTHLY:
            this.contracts.expenses.MONTHLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.TWOMONTHLY:
            this.contracts.expenses.TWOMONTHLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.QUARTERLY:
            this.contracts.expenses.QUARTERLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.HALFYEARLY:
            this.contracts.expenses.HALFYEARLY.push(contract);
            break;
          case ContractEntity.IntervalEnum.YEARLY:
            this.contracts.expenses.YEARLY.push(contract);
            break;
        }
      };
    });
  }

  syncBookingsPromptPin() {
    let alert = this.alertCtrl.create({
      title: 'Pin',
      inputs: [
        {
          name: 'pin',
          placeholder: 'Bank Account Pin',
          type: 'password'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel'
        },
        {
          text: 'Submit',
          handler: data => {
            if (data.pin.length > 0) {
              this.syncBookings(data.pin);
            }
          }
        }
      ]
    });
    alert.present();
  }

  syncBookings(pin) {
    if (!pin && !this.bankAccess.storePin) {
      return this.syncBookingsPromptPin();
    }

    let loading = this.loadingCtrl.create({
      content: 'Please wait...'
    });
    loading.present();

    this.bankAccountService.syncBookings(this.bankAccess.id, this.bankAccountId, pin).subscribe(
      response => {
        loading.dismiss();
      },
      messages => {
        if (messages instanceof Array) {
          messages.forEach(message => {
            if (message.key == "SYNC_IN_PROGRESS") {
              this.toastCtrl.create({
                message: 'Account sync in progress',
                showCloseButton: true,
                position: 'top'
              }).present();
            }
            else if (message.key == "INVALID_PIN") {
              this.alertCtrl.create({
                message: 'Invalid pin',
                buttons: ['OK']
              }).present();
            }
          });
        }
      })
  }
}
