package gamestates;

import main.Jogo;

public class State {
    protected Jogo jogo;

    public State(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogo getJogo() {
        return jogo;
    }
    
    
}
