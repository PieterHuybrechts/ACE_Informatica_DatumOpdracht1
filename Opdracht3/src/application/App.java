package application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import common.AntiMagicStrings;
import common.DBException;
import common.DBMissingException;
import common.enums.EnumTypeCd;
import common.enums.EnumTypeDvd;
import common.factories.CustomerFactory;
import common.factories.ItemFactory;
import common.factories.UitleningFactory;
import controller.ReceiptController;
import controller.WinkelController;
import controller.event.MainWindowChangedFiringSource;
import database.DataService;
import database.DataStrategy;
import database.helpers.DataSource;
import database.implementations.DataSourceFactory;
import model.BodyDecorator;
import model.ConcreteReceipt;
import model.Customer;
import model.FooterDecorator;
import model.HeaderDecorator;
import model.Item;
import model.Receipt;
import model.Shop;
import model.Uitlening;
import model.subItems.Cd;
import model.subItems.Dvd;
import model.subItems.Game;
import view.LoadingWindow;
import view.MainWindow;
import view.panels.CustomerOverview;

public class App {
	
	
	
	
	public static void main(String[] args) throws DBMissingException, DBException{
		
		int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                "Kies een database type", //Object message,
                "Db?", //String title
                JOptionPane.YES_NO_OPTION, //int optionType
                JOptionPane.INFORMATION_MESSAGE, //int messageType
                null, //Icon icon,
                DataSource.values(), //Object[] options,
                null);//Object initialValue 
		if (choice == -1) return;
		DataSourceFactory.setType(DataSource.values()[choice]);

		LoadingWindow bootscreen = new LoadingWindow();
		bootscreen.start();
	}
	
	
	


}
