/**
 * Application de facturation
 * C\'est une application web de genération de facture automatique avec l\'envoie par mail et par whatsapp
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: davidouthe2@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


export interface ProduitDto { 
    id?: number;
    nom?: string;
    prix?: number;
    quantite?: number;
    date_creation?: string;
    description?: string;
    img?: string;
    categorie_id?: number;
}

