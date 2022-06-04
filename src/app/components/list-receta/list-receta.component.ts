import { Component, OnInit } from '@angular/core';
import { Receta } from 'src/app/model/receta';
import { RecetaService } from 'src/app/services/receta.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
  
@Component({
  selector: 'app-list-receta',
  templateUrl: './list-receta.component.html',
  styleUrls: ['./list-receta.component.css']
})
export class ListRecetaComponent implements OnInit {

    recetaSet: Receta[];
    recetaFil: Receta[];
    collectionSize: number;
    searchTerm: string;
    closeModal: string;
    msgError = '';
    currentReceta = null;
    currentIndex = -1;
    
    constructor(private recetaService: RecetaService, 
                    private modalService: NgbModal) { 
                    }
  
    ngOnInit(): void {
      this.refreshList();
    }
  
    triggerModal(content:any, val:Receta) {
      this.currentReceta = val
      this.retrieveReceta(this.currentReceta.id)
      this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((res) => {
        this.closeModal = `Closed with: ${res}`;
      }, (res) => {
        this.closeModal = `Dismissed ${this.getDismissReason(res)}`;
      });
    }
    
    private getDismissReason(reason: any): string {
      if (reason === ModalDismissReasons.ESC) {
        return 'by pressing ESC';
      } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
        return 'by clicking on a backdrop';
      } else {
        return  `with: ${reason}`;
      }
    }
  
    search(value: string): void {
      this.recetaFil = this.recetaSet.filter((val) => val.nombre.toLowerCase().includes(value));
      this.collectionSize = this.recetaFil.length;
    }
  
    retrieveRecetas(): void {
      this.recetaService.getAll()
        .subscribe(
          data => {
            this.recetaSet = data;
            console.log(data);
          },
          error => {
            console.log(error);
            console.log("paila");
            
          });
    }
  
    retrieveReceta(val:string): void {
      this.recetaService.get(val)
        .subscribe(
          data => {
            this.currentReceta = data;
            console.log(data);
          },
          error => {
            this.msgError =  error.message +' \n '+ error.error.message;
            console.log(error);
          });
    }
  
    updateReceta(): void {
     this.recetaService.update(this.currentReceta.id, this.currentReceta)
        .subscribe(
          data => {
            this.refreshList();
            console.log(data);
          },
          error => {
            console.log(error);
          });
    }
  
    deleteReceta(val1:string): void {
      this.recetaService.delete(val1)
         .subscribe(
           data => {
             this.refreshList();
             console.log(data);
           },
           error => {
             console.log(error);
           });
     }
  
    setActiveBook(receta : Receta, index : number): void {
      this.currentReceta = receta;
      this.currentIndex = index
    }
  
    refreshList(): void {
      this.retrieveRecetas();
    }
  
  
  
  }