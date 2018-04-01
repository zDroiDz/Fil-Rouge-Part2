
#include 
#include 
#include "/SEARCH/by_keywordh"
#include "/INDEXATION/index_txth"
#include "/INDEXATION/index_soundh"
#include "/INDEXATION/index_imgh"
#include "menuh"


void viderBuffer
{
    int c = 0
    while c =  \n  && c = EOF
    {
        c = getchar
    }
}

int lirechar *chaine int longueur
{
    char *positionEntree = NULL

    if fgetschaine longueur stdin = NULL
    {
        positionEntree = strchrchaine  \n 
        if positionEntree = NULL
        {
            *positionEntree =  \0 
        }
        else
        {
            viderBuffer
        }
        return 1
    }
    else
    {
        viderBuffer
        return 0
    }
}

void modifConfigint valuechar* label
{
  char cmd[10000]
  FILE * ptr_fic
  char mot_fic[100]
  char nouvellesValeurs[10000]
  char conversion[10000]

  strcpynouvellesValeurs""

  ptr_fic = fopen"/EXTERN_FILES/configurationconfig" "r"

  if ptr_fic = NULL
  {
      while  fscanfptr_fic "s" mot_fic==1 
      {
            ifstrcmpmot_ficlabel==0
            {
              strcatnouvellesValeursmot_fic
              fscanfptr_fic "s" mot_fic
              strcatnouvellesValeurs" "
              snprintfconversionsizeofconversion"d"value
              strcatnouvellesValeursconversion

            }
            else
            {
              strcatnouvellesValeursmot_fic
            }
            strcatnouvellesValeurs" "
      }
      ifptr_fic=NULL
      {
        fcloseptr_fic
      }

      ptr_fic = fopen"/EXTERN_FILES/configurationconfig" "w"
      ifptr_fic=NULL
      {
        fprintfptr_fic"s"nouvellesValeurs
        ifptr_fic=NULL
        {
          fcloseptr_fic
        }
      }
      else
      {
         fprintfstderr "ERREUR   PB fonction modifConfig\n"
      }
  }
  else
  {
     fprintfstderr "ERREUR   PB fonction modifConfig\n"
  }


}


/* menu de base quand on arrive dans l api */
void menu_base {

  rmThenStartIndexation
  indexImage
  resetAndIndex
  /*

   printf"\nMenu principal  \n1 - Administrateur\n2 - Utilisateur\n3 - Quitter\n" 
   char choix[1]
   do {
     lirechoix2

     if  strcmpchoix"1"= 0 && strcmpchoix"2"= 0 && strcmpchoix"3"= 0  {
       printf"Probleme de saisie veuillez recommencer\n" 
     }

   } while strcmpchoix"1"= 0 && strcmpchoix"2"= 0  && strcmpchoix"3"= 0  


   if strcmpchoix"1" == 0  {
     menu_administrateur0
   }else if strcmpchoix"2" == 0  {
      menu_utilisateur
   }else ifstrcmpchoix"3" == 0 {
      exit 
   }
   */
}

void menu_administrateurint verif {


char mdp[500]
char choix[1]

if verif == 0 {
  printf"\nVeuillez entrer le mot de passe \n" 
  do {
    liremdp5

    if strcmpmdp"test" = 0  {
      printf"Mot de passe erroné réessayez \n" 
    }
  } whilestrcmpmdp"test" = 0 
}



printf"\nMenu administrateur \n1 - Lancer indexation\n2 - Configuration\n3 - Visualiser descripteurs\n4 - Retour au menu principal\n" 

do {

  lirechoix2

  if  strcmpchoix"1"= 0 && strcmpchoix"2"= 0 && strcmpchoix"3"= 0 && strcmpchoix"4"=0  {
    printf"Probleme de saisie veuillez recommencer\n" 
  }

} while strcmpchoix"1"= 0 && strcmpchoix"2"= 0   && strcmpchoix"3"= 0 && strcmpchoix"4"=0 

//indexation
   if strcmpchoix"1" == 0  {
      printf"Lancement de l indexation \n" 
      rmThenStartIndexation
      indexImage
      resetAndIndex

      menu_administrateur1
//menu Configuration
   }else if strcmpchoix"2" == 0  {
      menu_configuration

//menu visualiser descripteurs
   }else if strcmpchoix"3" == 0  {
     menu_visualiserdesc

     //retour au menu principal
   } else ifstrcmpchoix"4" == 0 {
     menu_base
   }



}

void menu_comparaison{
  printf"\nMenu recherche par comparaison  \n1 - Texte\n2 - Son\n3 - Image\n4 - Retour\n" 
  char choix[1]
  do {

    lirechoix2

    if  strcmpchoix"1"= 0 && strcmpchoix"2"= 0 && strcmpchoix"3"= 0 && strcmpchoix"4"=0  {
      printf"Probleme de saisie veuillez recommencer\n" 
    }

  } while strcmpchoix"1"= 0 && strcmpchoix"2"= 0   && strcmpchoix"3"= 0 && strcmpchoix"4"=0 


    char requete[2000]
  //Comparaison texte
     if strcmpchoix"1" == 0  {
        printf"Saisissez le chemin du fichier à comparer xml\n" 
    		scanf"s"requete
    		indexFileToComparerequete

  //Comparaison son
     }else if strcmpchoix"2" == 0  {
        printf"Saisissez le chemin du fichier à comparer bin\n" 
  			scanf"s" requete 
  			comparerequete

  //menu comparaison image
     }else if strcmpchoix"3" == 0  {
      printf"Saisissez le chemin du fichier à comparer txt\n" 
  		scanf"s"requete
      searchImagerequete

       //retour au menu utilisateur
     } else ifstrcmpchoix"4" == 0 {
       menu_utilisateur
     }

   viderBuffer
   menu_utilisateur

}

void menu_recherche_motcle{
    printf"\nRecherche par mot-clé\nVeuillez entrer un mot clé  \n" 
    char mot[2000]
    scanf"s" mot
  	bywordmot

    viderBuffer
    menu_utilisateur
}

void menu_visualiserdesc {
    printf"\nMenu visualiser descripteurs  \n1 - Texte\n2 - Son\n3 - Image\n4 - Retour\n" 
    char choix[1]
    do {

      lirechoix2

      if  strcmpchoix"1"= 0 && strcmpchoix"2"= 0 && strcmpchoix"3"= 0 && strcmpchoix"4"=0  {
        printf"Probleme de saisie veuillez recommencer\n" 
      }

    } while strcmpchoix"1"= 0 && strcmpchoix"2"= 0   && strcmpchoix"3"= 0 && strcmpchoix"4"=0 

    //Visualisation texte
       if strcmpchoix"1" == 0  {
          printf"Visualisation descripteurs texte\n" 
          system"cat /EXTERN_FILES/database/base_texte/base_descripteur_textetxt"
    //visualisation son
       }else if strcmpchoix"2" == 0  {
          printf"Visualisation descripteurs son\n" 
          system"cat /EXTERN_FILES/database/base_son/base_descripteur_sontxt"
    //visualisation image
       }else if strcmpchoix"3" == 0  {
        printf"Visualisation descripteurs image\n" 
        system"cat /EXTERN_FILES/database/base_image/base_descripteur_imagetxt"
         //retour au menu admin
       } else ifstrcmpchoix"4" == 0 {
         menu_administrateur1
       }

       menu_administrateur1
}

void menu_configuration {
  printf"\nMenu configuration  \n1 - Texte\n2 - Son\n3 - Image\n4 - Retour\n" 
  char choix[1]
  do {

    lirechoix2

    if  strcmpchoix"1"= 0 && strcmpchoix"2"= 0 && strcmpchoix"3"= 0 && strcmpchoix"4"=0  {
      printf"Probleme de saisie veuillez recommencer\n" 
    }

  } while strcmpchoix"1"= 0 && strcmpchoix"2"= 0   && strcmpchoix"3"= 0 && strcmpchoix"4"=0 

  //configuration texte
     if strcmpchoix"1" == 0  {
        printf"Configuration texte\n" 
        printf"Saisissez le nombre d occurences  \n" 
        int nbocc 
        scanf"d" &nbocc 
        modifConfignbocc "txt_nboccurrences"

  //configuration son
     }else if strcmpchoix"2" == 0  {
        printf"Configuration son\n" 
        menu_configuration_son

  //configuration image
     }else if strcmpchoix"3" == 0  {
      printf"Configuration image\n" 
        menu_configuration_image

       //retour au menu admin
     } else ifstrcmpchoix"4" == 0 {
       menu_administrateur1
     }
    viderBuffer
     menu_administrateur1
}

void menu_configuration_son {
printf"\nMenu configuration son\n1 - Nombre d échantillons\n2 - Nombre de fenetres\n3 - Retour\n" 

char choix[1]

do {
  lirechoix2

  if  strcmpchoix"1"= 0 && strcmpchoix"2"= 0 && strcmpchoix"3"= 0  {
    printf"Probleme de saisie veuillez recommencer\n" 
  }

} whilestrcmpchoix"1"= 0 && strcmpchoix"2"= 0  && strcmpchoix"3"= 0

int valeur 

if strcmpchoix"1" == 0  {
   printf"Saisissez le nombre d échantillons  \n" 
   scanf"d" &valeur 
   modifConfigvaleur "echantillions"
//menu comparaison
}else if strcmpchoix"2" == 0  {
   printf"Saisissez le nombre d intervalles  \n" 
   scanf"d" &valeur 
   modifConfigvaleur "nbintervalles"
//Retour
}else ifstrcmpchoix"3" == 0 {
  menu_configuration
}

viderBuffer
menu_administrateur1

}

void menu_configuration_image {
printf"\nMenu configuration image\n1 - Nombre de bits de quantification NB\n2 - Nombre de bits de quantification RVB\n3 - Retour\n" 

char choix[1]

do {
  lirechoix2

  if  strcmpchoix"1"= 0 && strcmpchoix"2"= 0 && strcmpchoix"3"= 0  {
    printf"Probleme de saisie veuillez recommencer\n" 
  }

} whilestrcmpchoix"1"= 0 && strcmpchoix"2"= 0  && strcmpchoix"3"= 0

  int valeur 

if strcmpchoix"1" == 0  {
   printf"Saisissez le nombre de bits de quantification NB  \n" 
   scanf"d" &valeur 
   modifConfigvaleur "NbBit_NB"
//menu comparaison
}else if strcmpchoix"2" == 0  {
   printf"Saisissez le nombre de quantification RVB  \n" 
   scanf"d" &valeur 
   modifConfigvaleur "NbBit_RGB"
//Retour
}else ifstrcmpchoix"3" == 0 {
  menu_configuration
}
viderBuffer
menu_administrateur1
}

void menu_utilisateur {

   printf"\nMenu utilisateur  \n1 - Recherche par mot-clé\n2 - Recherche par comparaison\n3 - Retour au menu principal\n" 
char choix[1]
   //entrée du menu
   do {

     lirechoix2

     if  strcmpchoix"1"= 0 && strcmpchoix"2"= 0 && strcmpchoix"3"= 0  {
       printf"Probleme de saisie veuillez recommencer\n" 
     }

   } while strcmpchoix"1"= 0 && strcmpchoix"2"= 0   && strcmpchoix"3"= 0 

//après premier choix

//recherche par mot clé
   if strcmpchoix"1" == 0  {
      menu_recherche_motcle

//menu comparaison
   }else if strcmpchoix"2" == 0  {
      menu_comparaison

//Retour
   }else if strcmpchoix"3" == 0  {

     menu_base
   }


}


/*
int mainint argc char const *argv[] {

menu_base


  return 0
}*/
