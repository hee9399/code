console.log('splicejs 실행');

var wavesurfer = WaveSurfer.create({
    container: '#waveform',
    waveColor: '#137a7f',
    progressColor: 'blue',
    //audioRate: 2,
    //splitChannels: true,
    //normalize: true,
});

wavesurfer.load('/jspweb/DBM_CK_KICK_18.wav');

playstop = () => {
  if(wavesurfer.isPlaying()){  
     wavesurfer.setCurrentTime(0)
     wavesurfer.pause();
  }
  else{
    wavesurfer.play();
  }
};

var wavesurfer2 = WaveSurfer.create({
    container: '#waveform2',
    waveColor: '#137a7f',
    progressColor: 'blue',
    //audioRate: 2,
    //splitChannels: true,
    //normalize: true,
});

wavesurfer2.load('/jspweb/splice/sample/vox/PMND_Vocal_Chop_110BPM_03_Bm.wav');

playstop2 = () => {
  if(wavesurfer2.isPlaying()){  
     wavesurfer2.setCurrentTime(0)
     wavesurfer2.pause();
  }
  else{
     wavesurfer2.play();
  }
};

