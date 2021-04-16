package day_0416;

public class Audio implements RemoteControl{
	
	private int volume;
	private boolean mute;

	@Override
	public void turnOn() {
		System.out.println("오디오 켜기");
		
	}

	@Override
	public void turnOff() {
		System.out.println("오디오 끄기");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨: " + this.volume);
		
	}
	
	@Override
	public void setMute(boolean mute) {
		this.mute = mute;
		if (mute) {
			System.out.println("Audio 무음 처리합니다.");
		} else {
			System.out.println("Audio 무음 해제합니다.");
		}
	}

}
