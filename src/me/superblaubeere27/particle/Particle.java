package me.superblaubeere27.particle;

import me.superblaubeere27.util.MathUtil;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

import java.util.Random;

public class Particle {
    private static final Random random = new Random();

    private Vector2f velocity;
    private Vector2f pos;
    private float size;
    private float alpha;


    public Particle(Vector2f velocity, float x, float y, float size) {
        this.velocity = velocity;
        this.pos = new Vector2f(x, y);
        this.size = size;
    }

    public static Particle generateParticle() {
        Vector2f velocity = new Vector2f((float) (Math.random() * 2.0f - 1.0f), (float) (Math.random() * 2.0f - 1.0f));
        float x = random.nextInt(Display.getWidth());
        float y = random.nextInt(Display.getHeight());
        float size = (float) (Math.random() * 4.0f) + 1.0f;
        return new Particle(velocity, x, y, size);
    }

    public float getAlpha() {

        return this.alpha;

    }

    public Vector2f getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    public float getX() {
        return pos.getX();
    }

    public void setX(float x) {
        this.pos.setX(x);
    }

    public float getY() {
        return pos.getY();
    }

    public void setY(float y) {
        this.pos.setY(y);
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void tick(int delta, float speed) {
        pos.x += velocity.getX() * delta * speed;
        pos.y += velocity.getY() * delta * speed;
        if(alpha < 255.0f)this.alpha += 0.05f * delta;

        if (pos.getX() > Display.getWidth()) pos.setX(0);
        if (pos.getX() < 0) pos.setX(Display.getWidth());

        if (pos.getY() > Display.getHeight()) pos.setY(0);
        if (pos.getY() < 0) pos.setY(Display.getHeight());
    }

    public float getDistanceTo(Particle particle1) {
        return getDistanceTo(particle1.getX(), particle1.getY());
    }

    public float getDistanceTo(float x, float y) {
        return (float) MathUtil.distance(getX(), getY(), x, y);
    }
}
