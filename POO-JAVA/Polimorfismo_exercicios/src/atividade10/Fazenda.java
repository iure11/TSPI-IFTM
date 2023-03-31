package atividade10;

class Fazenda {
    public void alimentarAnimais(Animal[] animais) {
        for (Animal animal : animais) {
            animal.comer();
        }
    }
}
