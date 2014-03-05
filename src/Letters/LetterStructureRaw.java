package Letters;

import org.andengine.entity.sprite.AnimatedSprite;
import Duster.Duster;
import Popup.PopUp;

import com.example.banglaletterwriting.GameActivity;
import com.example.banglaletterwriting.NumberSprites;
import com.example.banglaletterwriting.R;
import com.example.banglaletterwriting.StructureDrawAnimation;

public class LetterStructureRaw 
{
	
	//create numberSprite and cursor
	public static void createNumberSpriteAndCursor()
	{
			 
		//creating the first line of numbers
		GameActivity.spriteCounterLimit = 4;
		StructureDrawAnimation.scale(GameActivity.moOutLineX + 70 - 100, GameActivity.moOutLineY - 70, 1);
					
		//creating the fish cursor
		GameActivity.cursor = new AnimatedSprite(GameActivity.moOutLineX, GameActivity.moOutLineY, 
				GameActivity.mFishTextureRegion, GameActivity.vertexBufferObjectManager);
		GameActivity.cursor.animate(new long[]{100, 100, 100, 100, 100, 100}, 0, 5, true);
		GameActivity.cursor.setZIndex(3);
		GameActivity.mScene.attachChild(GameActivity.cursor);
					
		//setting the cursor to top of first number sprite
		NumberSprites.setCursorPosition(GameActivity.numberSprites[1]);
					
	}
	
	public static void Structure()
	{
		
		if(GameActivity.spriteCounterLimit == 4) 
		{ 
			GameActivity.spriteCounter++;
			StructureDrawAnimation.scale(GameActivity.moOutLineX+70*GameActivity.spriteCounter - 120, 
					GameActivity.moOutLineY -70, GameActivity.spriteCounter); 
		}
		else if(GameActivity.spriteCounterLimit == 7)
		{
			GameActivity.spriteCounter++;
			StructureDrawAnimation.scale(GameActivity.moOutLineX-70*GameActivity.spriteCounter + 480 ,
					GameActivity.moOutLineY+40*GameActivity.spriteCounter - 240,
					GameActivity.spriteCounter);
		}
		else if(GameActivity.spriteCounterLimit == 9)
		{ 
			GameActivity.spriteCounter++;
			StructureDrawAnimation.scale(GameActivity.moOutLineX-50*GameActivity.spriteCounter +580 ,
					GameActivity.moOutLineY-30*GameActivity.spriteCounter + 400,
					GameActivity.spriteCounter);  
		} 
		
		else if(GameActivity.spriteCounterLimit == 13)
		{
			GameActivity.spriteCounter++; 
			StructureDrawAnimation.scale(GameActivity.moOutLineX+120 , 
					GameActivity.moOutLineY-60*GameActivity.spriteCounter+730,
					GameActivity.spriteCounter);
		}

	
	}

	public static void getStructure(float x, float y) 
	{
		

		if(GameActivity.state==1)
		{
			//Drawing the chalk
			StructureDrawAnimation.Draw(x, y); 
			
			//setting the position of posX, posY
			GameActivity.posX = GameActivity.numberSprites[1].getX()+GameActivity.numberSprites[1].getWidth()/2-20;
			GameActivity.posY = GameActivity.numberSprites[1].getY()+GameActivity.numberSprites[1].getHeight()/2-20;

			if( 
				   GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
				||GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>30 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55 
					)
			{ 
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[1]);
				
				//if out of the area the remove white chalks
				for(int a=0; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					} 
				}
				
			}
			//if in the area and collides the right number sprite then remove and pass to the next number sprite
			else 
			{
				NumberSprites.setCursorRotation(x, y);
				
				remove(2, 1,2);
			}
			
		}  
		else if(GameActivity.state==2)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[2].getX()+GameActivity.numberSprites[2].getWidth()/2-20;
			GameActivity.posY = GameActivity.numberSprites[2].getY()+GameActivity.numberSprites[2].getHeight()/2-20;

			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 ||GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>30 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[2]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(3,2,3);
			}
		}
		else if(GameActivity.state==3)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[3].getX()+GameActivity.numberSprites[3].getWidth()/2-20;
			GameActivity.posY = GameActivity.numberSprites[3].getY()+GameActivity.numberSprites[3].getHeight()/2-20;
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 ||GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>30 
				|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55 
				)
			{
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[3]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
						//if wrong and not shaking the shake as wrong signal
						if(GameActivity.isShaking == false)
						{
							StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);

						}
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(4,3,4);
			}
		}
		else if(GameActivity.state==4)
		{
			GameActivity.mScene.detachChild(GameActivity.numberSprites[4]);
			//creating new line of numbers
			GameActivity.spriteCounterLimit=7;
			StructureDrawAnimation.scale(GameActivity.moOutLineX +120,
					GameActivity.moOutLineY-30, GameActivity.spriteCounter); 
			GameActivity.state=5;
		}
		else if(GameActivity.state==5)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[5].getX()+GameActivity.numberSprites[5].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[5].getY()+GameActivity.numberSprites[5].getHeight()/2-20;
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>30 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55 
					)
			{
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[5]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				}
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(6,5,6);
			}
		}
		else if(GameActivity.state==6)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[6].getX()+GameActivity.numberSprites[6].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[6].getY()+GameActivity.numberSprites[6].getHeight()/2-20;
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>30 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[6]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				}
				
			}
			else 
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(7,6,7);
			}
		}  
		else if(GameActivity.state==7)
		{
			GameActivity.spriteCounterLimit=9;
			StructureDrawAnimation.scale(GameActivity.moOutLineX-50*GameActivity.spriteCounter +460 ,
					GameActivity.moOutLineY-30*GameActivity.spriteCounter + 320, GameActivity.spriteCounter); 
			GameActivity.state=8;
		}
		else if(GameActivity.state==8)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[7].getX()+GameActivity.numberSprites[7].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[7].getY()+GameActivity.numberSprites[7].getHeight()/2-20;
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -65 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55  
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[7]); 
				
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				} 
			}
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(8,7,9);
			}
		}
		else if(GameActivity.state==9)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[8].getX()+GameActivity.numberSprites[8].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[8].getY()+GameActivity.numberSprites[8].getHeight()/2-20;
			
			if( 
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55 
					)
			{ 
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[8]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(9,8,10);
			} 
		}
		else if(GameActivity.state==10)
		{
			GameActivity.mScene.detachChild(GameActivity.numberSprites[9]);
			
			
			GameActivity.spriteCounterLimit=13;
			StructureDrawAnimation.scale(GameActivity.moOutLineX+40*GameActivity.spriteCounter -280 ,
					GameActivity.moOutLineY+50*GameActivity.spriteCounter-360, GameActivity.spriteCounter); 
			//NumberSprites.setCursorPosition(MainActivity.numberSprites[10]);
			
			GameActivity.state=11; 
			
		} 
		 
		else if(GameActivity.state==11)
		{
			StructureDrawAnimation.Draw(x, y);
			
			NumberSprites.setCursorPosition(GameActivity.numberSprites[10]);
			
			GameActivity.posX = GameActivity.numberSprites[10].getX()+GameActivity.numberSprites[10].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[10].getY()+GameActivity.numberSprites[10].getHeight()/2-20;
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-35 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[10]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(10,9,12);
			}
		}
		else if(GameActivity.state==12)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[10].getX()+GameActivity.numberSprites[10].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[10].getY()+GameActivity.numberSprites[10].getHeight()/2-20;
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[10]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(11,10,13);
			}
		}
		else if(GameActivity.state==13)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[11].getX()+GameActivity.numberSprites[11].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[11].getY()+GameActivity.numberSprites[11].getHeight()/2-20;
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-75 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[11]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
	                
				remove(12,11,14);
			}
		}
		
		else if(GameActivity.state==14)
		{
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[12].getX()+GameActivity.numberSprites[12].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[12].getY()+GameActivity.numberSprites[12].getHeight()/2-20;
			
			//rect(MainActivity.posX, MainActivity.posY);
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>50 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-60 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[12]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
				
				remove(13,12,16);
			}
		}
		else if(GameActivity.state==16)
		{
			GameActivity.mScene.detachChild(GameActivity.numberSprites[13]);
			GameActivity.spriteCounterLimit=17;
			StructureDrawAnimation.scale(GameActivity.moOutLineX+40 , 
					GameActivity.moOutLineY+80*GameActivity.spriteCounter-980, GameActivity.spriteCounter); 
			GameActivity.state=17; 
		}
		else if(GameActivity.state==17)
		{
			
			StructureDrawAnimation.Draw(x, y);
			
			GameActivity.posX = GameActivity.numberSprites[14].getX()+GameActivity.numberSprites[14].getWidth()/2-20; 
			GameActivity.posY = GameActivity.numberSprites[14].getY()+GameActivity.numberSprites[14].getHeight()/2-20;
			
			if(
					 GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX< -55 
					 	|| GameActivity.whiteChalk[GameActivity.aCounter].getX() - GameActivity.posX>30 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY>30 
						|| GameActivity.whiteChalk[GameActivity.aCounter].getY() - GameActivity.posY<-55 
					)
			{
				
				//set the cursor to the last collided number sprite
				NumberSprites.setCursorPosition(GameActivity.numberSprites[14]);
				
				//if out of the area the remove white chalks
				for(int a=GameActivity.wCounter; a<=GameActivity.aCounter; a++)
				{
					GameActivity.mScene.detachChild(GameActivity.whiteChalk[a]);
					//if wrong and not shaking the shake as wrong signal
					if(GameActivity.isShaking == false)
					{
						StructureDrawAnimation.shake(1, GameActivity.OutLine, 10);
					}
				} 
				
			} 
			else
			{
				//Move the cursor with touch
				NumberSprites.setCursorRotation(x, y);
	                
				remove(14,13,18);
			} 
		} 
//		else if(MainActivity.state==18)
//		{
//			StructureDrawAnimation.Draw(x, y);
//			
//			MainActivity.posX = MainActivity.numberSprites[14].getX()+MainActivity.numberSprites[14].getWidth()/2-20; 
//			MainActivity.posY = MainActivity.numberSprites[14].getY()+MainActivity.numberSprites[14].getHeight()/2-20;
//			
//			if(
//					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
//					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
//						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
//						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-50 
//					)
//			{
//				
//				//set the cursor to the last collided number sprite
//				NumberSprites.setCursorPosition(MainActivity.numberSprites[14]);
//				
//				//if out of the area the remove white chalks
//				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
//				{
//					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
//					//if wrong and not shaking the shake as wrong signal
//					if(MainActivity.isShaking == false)
//					{
//						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
//					}
//				} 
//				
//			} 
//			else
//			{
//				//Move the cursor with touch
//				NumberSprites.setCursorRotation(x, y);
//				
//				remove(15,14,19); 
//			}
//		} 
//		else if(MainActivity.state==19)
//		{
//			StructureDrawAnimation.Draw(x, y);
//			
//			MainActivity.posX = MainActivity.numberSprites[15].getX()+MainActivity.numberSprites[15].getWidth()/2-20; 
//			MainActivity.posY = MainActivity.numberSprites[15].getY()+MainActivity.numberSprites[15].getHeight()/2-20;
//			
//			if(
//					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
//					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
//						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>50 
//						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55
//					)
//			{
//				
//				//set the cursor to the last collided number sprite
//				NumberSprites.setCursorPosition(MainActivity.numberSprites[15]);
//				
//				//if out of the area the remove white chalks
//				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
//				{
//					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
//					//if wrong and not shaking the shake as wrong signal
//					if(MainActivity.isShaking == false)
//					{
//						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
//					}
//				} 
//				
//			} 
//			else
//			{
//				//Move the cursor with touch
//				NumberSprites.setCursorRotation(x, y);
//				
//				remove(16,15,20); 
//			}
//		}
//		else if(MainActivity.state==20)
//		{
//			StructureDrawAnimation.Draw(x, y);
//			
//			MainActivity.posX = MainActivity.numberSprites[16].getX()+MainActivity.numberSprites[16].getWidth()/2-20; 
//			MainActivity.posY = MainActivity.numberSprites[16].getY()+MainActivity.numberSprites[16].getHeight()/2-20;
//			
//			if(
//					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
//					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>30 
//						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>70 
//						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
//					)
//			{ 
//
//				
//				//set the cursor to the last collided number sprite
//				NumberSprites.setCursorPosition(MainActivity.numberSprites[16]);
//				
//				//if out of the area the remove white chalks
//				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
//				{
//					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
//					//if wrong and not shaking the shake as wrong signal
//					if(MainActivity.isShaking == false)
//					{
//						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
//					}
//				}
//				
//			} 
//			else
//			{
//				//Move the cursor with touch
//				NumberSprites.setCursorRotation(x, y);
//	                
//				remove(17,16,21); 
//			}
//		}
//		
//		else if(MainActivity.state==21) 
//		{
//			MainActivity.mScene.detachChild(MainActivity.numberSprites[17]);
//			
//			MainActivity.spriteCounterLimit=19;
//			StructureDrawAnimation.scale(MainActivity.moOutLineX+160 , 
//					MainActivity.moOutLineY+80*MainActivity.spriteCounter-1480, MainActivity.spriteCounter); 
//			MainActivity.state=22; 
//		}
//		else if(MainActivity.state==22)
//		{
//			StructureDrawAnimation.Draw(x, y);
//			
//			MainActivity.posX = MainActivity.numberSprites[18].getX()+MainActivity.numberSprites[18].getWidth()/2-20; 
//			MainActivity.posY = MainActivity.numberSprites[18].getY()+MainActivity.numberSprites[18].getHeight()/2-20;
//			
//			if(
//					 MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX< -55 
//					 	|| MainActivity.whiteChalk[MainActivity.aCounter].getX() - MainActivity.posX>50 
//						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY>30 
//						|| MainActivity.whiteChalk[MainActivity.aCounter].getY() - MainActivity.posY<-55 
//					)
//			{
//
//				
//				//set the cursor to the last collided number sprite
//				NumberSprites.setCursorPosition(MainActivity.numberSprites[18]);
//				
//				//if out of the area the remove white chalks
//				for(int a=MainActivity.wCounter; a<=MainActivity.aCounter; a++)
//				{
//					MainActivity.mScene.detachChild(MainActivity.whiteChalk[a]);
//					//if wrong and not shaking the shake as wrong signal
//					if(MainActivity.isShaking == false)
//					{
//						StructureDrawAnimation.shake(1, MainActivity.OutLine, 10);
//					}
//				} 
//				
//			} 
//			else
//			{
//				//Move the cursor with touch
//				NumberSprites.setCursorRotation(x, y);
//	                
//				remove(19,18,23); 
//			}
//		} 
	}
	
	
	public static void remove(int collisionSprite, int removeSpriteNumber, int stateNumber)
	{
		
		if(GameActivity.whiteChalk[GameActivity.aCounter].collidesWith(GameActivity.numberSprites[collisionSprite]))
		{
			//removing when it is in the last state
			if(collisionSprite == 14)
			{ 
				GameActivity.mScene.detachChild(GameActivity.numberSprites[14]);
				
				//trigger for taking screen shot
				GameActivity.screenShotCounter = 1;
				//create book icon
				PopUp.createBookIcon();
				//start duster
				Duster.startDuster();
				
				GameActivity.isActionMoving = false;
				
				//start the hand tutorial 
//				MainActivity.tutorialCounter++;
//				if(MainActivity.tutorialCounter==1)
//				{
					//HandTutorial.handTutorialCreate();
//				}
			}
			GameActivity.mScene.detachChild(GameActivity.numberSprites[removeSpriteNumber]);
			GameActivity.numberSprites[removeSpriteNumber].setY(GameActivity.CAMERA_HEIGHT+500);
			GameActivity.wCounter =GameActivity. aCounter+2;
			GameActivity.state = stateNumber;
			
			//play sound
			GameActivity.audioPlay = true;
			NumberSprites.playAudio(R.raw.star);
			
		}
	}

}
