export * from './authenticationController.service';
import { AuthenticationControllerService } from './authenticationController.service';
export * from './categorieController.service';
import { CategorieControllerService } from './categorieController.service';
export * from './factureController.service';
import { FactureControllerService } from './factureController.service';
export * from './pdfController.service';
import { PdfControllerService } from './pdfController.service';
export * from './produitController.service';
import { ProduitControllerService } from './produitController.service';
export * from './userController.service';
import { UserControllerService } from './userController.service';
export const APIS = [AuthenticationControllerService, CategorieControllerService, FactureControllerService, PdfControllerService, ProduitControllerService, UserControllerService];
