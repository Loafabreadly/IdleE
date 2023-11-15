package com.github.loafabreadly;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.github.loafabreadly.Utilities.Constants;

public class MyGdxGame extends ApplicationAdapter {

	private Stage stage;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(new InputMultiplexer(stage));
		createMainUI();
	}

	private void createMainUI() {
		Skin skin = new Skin(Gdx.files.internal("skin/flat-earth-ui.json"));

		TextButton companyButton = new TextButton("Create Company", skin);
		companyButton.setPosition(Gdx.graphics.getWidth() / 2f - companyButton.getWidth() / 2f, Gdx.graphics.getHeight() / 2f - companyButton.getHeight() / 2f ); //Set the button in the middle
		companyButton.getStyle().up = skin.newDrawable("white", Color.valueOf(Constants.OXFORDBLUE)); //Set the color of the button to our constant
		companyButton.getStyle().down = skin.newDrawable("white", Color.valueOf(Constants.YINMNBLUE));
		companyButton.getStyle().over = skin.newDrawable("white", Color.valueOf(Constants.PLATINUM));

		companyButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				showCompanyCreationUI();
			}
		});

		stage.addActor(companyButton);

		stage.getRoot().setColor(Color.valueOf(Constants.OXFORDBLUE)); //Set the Background color
	}

	private void showCompanyCreationUI() {
		Skin skin = new Skin(Gdx.files.internal("skin/flat-earth-ui.json"));

		Dialog settingsDiag = new Dialog("Settings", skin);

		TextField nameField = new TextField("", skin);
		settingsDiag.getContentTable().add("Company Name: ");
		settingsDiag.getContentTable().add(nameField).row();

		Slider moneySlider = new Slider(0, 100, 1, false, skin);
		settingsDiag.getContentTable().add("Starting Money: ");
		settingsDiag.getContentTable().add(moneySlider).row();

		CheckBox saveBox = new CheckBox("Save Company?", skin);
		settingsDiag.getContentTable().add(saveBox).row();

		settingsDiag.button("Finish", true).button("Cancel", false);
		settingsDiag.setPosition(Gdx.graphics.getWidth() / 2f - settingsDiag.getWidth() / 2f, Gdx.graphics.getHeight() / 2f - settingsDiag.getHeight() / 2f );
		settingsDiag.setHeight(settingsDiag.getPrefHeight());
		settingsDiag.setWidth(settingsDiag.getPrefWidth());
		settingsDiag.toFront();

		stage.addActor(settingsDiag);
	}
	@Override
	public void render () {
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}
