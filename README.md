# Devoir n°3 – Patrons de construction (INF461)

**Étudiant :** GOYE AWOUMA CHAÏNE LEONEL — matricule 0000
**Cours :** INF461 *Principes et processus du logiciel* — Pr KIMBI Xaveria

| Dossier | Patron | Exemple du cours | Exemple modifié |
|---|---|---|---|
| [`patron-singleton/`](patron-singleton/) | Singleton | Exemples 1 et 2 du cours | Journal d'application **thread-safe** (double-checked locking) |
| [`patron-builder/`](patron-builder/) | Builder (Monteur) | Pizzas Reine et Piquante | Directeur conforme au modèle générique, étape *fromage*, pizza **Végétarienne** |

Chaque dossier contient le code source (`src/cours`, `src/modifie`), les diagrammes de classes
réalisés avec **Dia** (`diagrammes/*.dia` + export `.png`) et un README avec les commandes d'exécution.

## Exécution (JDK 17)

```bash
cd patron-singleton    # ou patron-builder
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out modifie.Client
```
